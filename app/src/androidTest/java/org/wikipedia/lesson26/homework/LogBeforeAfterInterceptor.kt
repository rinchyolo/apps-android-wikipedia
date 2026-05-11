package org.wikipedia.lesson26.homework

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor

class LogBeforeAfterInterceptor : ViewBehaviorInterceptor {

    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        Log.d("KASPRESSO", "BEFORE ACTION")

        return try {
            action()
        } finally {
            Log.d("KASPRESSO", "AFTER ACTION")
        }
    }
}