dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal() // 插件仓库
    }

    versionCatalogs {
        create("libs") {
            // 从主项目的 gradle 文件夹中加载 toml 文件
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

// 我们的约定插件将在这里定义
include(":conventions")