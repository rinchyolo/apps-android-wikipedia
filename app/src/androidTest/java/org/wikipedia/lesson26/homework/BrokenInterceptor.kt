package org.wikipedia.lesson26.homework

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor

class BrokenInterceptor : ViewBehaviorInterceptor {

    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        Log.d("KASPRESSO", "ACTION WAS INTERCEPTED, BUT NOT EXECUTED")
        throw IllegalStateException(
            "Мы специально не вызываем action(), поэтому Espresso-действие не выполнится"
        )
    }
}