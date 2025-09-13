@file:Suppress("unused")

package com.emcck.fluent.chat.common.logger

import co.touchlab.kermit.Logger
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

object Logger {

    private var logType: LogType = LogType.Napier

    init {
        Napier.base(DebugAntilog())
    }

    private val tag: String
        get() = "FluentChat"

    sealed class LogType {
        object Napier : LogType()

        object Kermit : LogType()
    }

    fun setLogType(logType: LogType) {
        this.logType = logType
    }

    fun v(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.Napier -> {
                Napier.v(throwable, tag ?: this.tag, message)
            }

            LogType.Kermit -> {
                Logger.Companion.v(throwable, tag = tag ?: this.tag, message)
            }
        }
    }

    fun d(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.Napier -> {
                Napier.d(throwable, tag ?: this.tag, message)
            }

            LogType.Kermit -> {
                Logger.Companion.d(throwable, tag ?: this.tag, message)
            }
        }
    }

    fun i(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.Napier -> {
                Napier.i(throwable, tag ?: this.tag, message)
            }

            LogType.Kermit -> {
                Logger.Companion.i(throwable, tag ?: this.tag, message)
            }
        }
    }

    fun w(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.Napier -> {
                Napier.w(throwable, tag ?: this.tag, message)
            }

            LogType.Kermit -> {
                Logger.Companion.w(throwable, tag ?: this.tag, message)
            }
        }
    }

    fun e(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.Napier -> {
                Napier.e(throwable, tag ?: this.tag, message)
            }

            LogType.Kermit -> {
                Logger.Companion.e(throwable, tag ?: this.tag, message)
            }
        }
    }

    fun a(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.Napier -> {
                Napier.wtf(throwable, tag ?: this.tag, message)
            }

            LogType.Kermit -> {
                Logger.Companion.a(throwable, tag ?: this.tag, message)
            }
        }
    }

}