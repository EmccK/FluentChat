import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl` // 核心插件，用于编写 .gradle.kts 类型的插件
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}

dependencies {
    // 在插件中需要访问这些插件的API
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

// gradlePlugin {
//     plugins {
//         // 注册我们的自定义插件
//         register("composeMultiplatformLibrary") {
//             id = "my-project.compose-multiplatform.library"
//             implementationClass = "MyProjectComposeMultiplatformLibraryConventionPlugin"
//         }
//         // 你也可以在这里用 .gradle.kts 文件名隐式注册
//     }
// }