package org.wikipedia.lesson26.classwork

import android.util.Log
import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewAssertionWatcherInterceptor

class MyViewAssertionInterceptor : ViewAssertionWatcherInterceptor {
    override fun intercept(
        viewAssertion: ViewAssertion,
        view: View?,
        exception: NoMatchingViewException?
    ) {
        Log.i("KASPRESSO", "Before assertion")
        if (exception != null) {
            Log.e("KASPRESSO", "Assertion: ${exception.message}")
        }
    }
}