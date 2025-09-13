@file:Suppress("unused")

package com.emcck.fluent.chat.common

import co.touchlab.kermit.Logger
import io.github.aakira.napier.Napier

object Logger {

    private var logType = LogType.NAPIER

    enum class LogType {
        NAPIER,
        KERMIT
    }

    fun setLogType(logType: LogType) {
        this.logType = logType
        if (this.logType == LogType.KERMIT) {
            Logger.setTag("FluentChat")
        }
    }

    fun v(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.NAPIER -> {
                Napier.v(throwable, tag, message)
            }
            LogType.KERMIT -> {
                Logger.v(throwable, tag = tag ?: Logger.tag, message)
            }
        }
    }

    fun d(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.NAPIER -> {
                Napier.d(throwable, tag, message)
            }
            LogType.KERMIT -> {
                Logger.d(throwable, tag = tag ?: Logger.tag, message)
            }
        }
    }

    fun i(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.NAPIER -> {
                Napier.i(throwable, tag, message)
            }
            LogType.KERMIT -> {
                Logger.i(throwable, tag = tag ?: Logger.tag, message)
            }
        }
    }

    fun w(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.NAPIER -> {
                Napier.w(throwable, tag, message)
            }
            LogType.KERMIT -> {
                Logger.w(throwable, tag = tag ?: Logger.tag, message)
            }
        }
    }

    fun e(tag: String? = null, throwable: Throwable? = null, message: () -> String) {
        when (logType) {
            LogType.NAPIER -> {
                Napier.e(throwable, tag, message)
            }
            LogType.KERMIT -> {
                Logger.e(throwable, tag = tag ?: Logger.tag, message)
            }
        }
    }

}