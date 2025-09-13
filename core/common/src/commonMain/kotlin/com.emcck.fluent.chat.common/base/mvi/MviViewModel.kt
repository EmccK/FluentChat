@file:Suppress("unused")

package com.emcck.fluent.chat.common.base.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class MviViewModel<State : UiState, Action : UiAction, Event : UiSingleEvent> :
    ViewModel() {

    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initState())
    val uiState: StateFlow<State> = _uiState.asStateFlow()

    private val _actions = Channel<Action>(Channel.BUFFERED)

    private val _events = Channel<Event>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        viewModelScope.launch {
            _actions.receiveAsFlow().collect {
                handleAction(it)
            }
        }
    }

    abstract fun handleAction(action: Action)

    abstract fun initState(): State

    protected fun sendEvent(event: Event) {
        viewModelScope.launch {
            _events.send(event)
        }
    }

    fun submitAction(action: Action) {
        viewModelScope.launch {
            _actions.send(action)
        }
    }

    protected fun updateState(newState: State) {
        _uiState.value = newState
    }

    protected fun updateState(func: State.() -> State) {
        _uiState.update(func)
    }

    override fun onCleared() {
        super.onCleared()
        _events.close()
        _actions.close()
    }

}