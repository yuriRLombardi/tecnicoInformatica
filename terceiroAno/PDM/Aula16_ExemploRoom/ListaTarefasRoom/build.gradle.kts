// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
    // TODO(3) Adicionar a linha abaixo para dar suporte a serialization
    kotlin("plugin.serialization") version libs.versions.kotlin
}