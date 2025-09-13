package com.emcck.fluent.chat

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform