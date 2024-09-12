plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.5.2").apply(false)
    id("com.android.library").version("8.5.2").apply(false)
    kotlin("android").version("2.0.20").apply(false)
    kotlin("multiplatform").version("2.0.20").apply(false)
    id("org.jetbrains.kotlin.plugin.compose").version("2.0.20").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
