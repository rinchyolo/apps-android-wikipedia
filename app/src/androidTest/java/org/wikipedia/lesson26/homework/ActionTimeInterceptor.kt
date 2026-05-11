package org.wikipedia.lesson26.homework

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor

class ActionTimeInterceptor : ViewBehaviorInterceptor {

    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        val startTime = System.currentTimeMillis()

        return try {
            action()
        } finally {
            val duration = System.currentTimeMillis() - startTime
            Log.d("KASPRESSO", "ACTION TOOK $duration ms")
        }
    }
}
