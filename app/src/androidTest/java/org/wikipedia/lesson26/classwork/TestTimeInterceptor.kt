package org.wikipedia.lesson26.classwork

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor

class TestTimeInterceptor : ViewBehaviorInterceptor {

    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        val beforeTime = System.currentTimeMillis()
        val result = action()
        val afterTime = System.currentTimeMillis()
        Log.i("KASPRESSO", "Time: ${afterTime - beforeTime}")
        return result
    }

}