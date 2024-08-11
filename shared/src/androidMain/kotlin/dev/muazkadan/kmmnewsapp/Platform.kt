package dev.muazkadan.kmmnewsapp

import org.koin.core.annotation.Single

@Single
actual class Platform actual constructor() {
    actual val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}