package org.wikipedia.lesson26.homework

import android.util.Log
import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewAssertionWatcherInterceptor

class AssertFailureWatcherInterceptor : ViewAssertionWatcherInterceptor {

    override fun intercept(
        viewAssertion: ViewAssertion,
        view: View?,
        exception: NoMatchingViewException?
    ) {
        if (exception != null) {
            Log.e(
                "KASPRESSO",
                "ASSERT FAILED: view was not found before assertion",
                exception
            )
        }
    }
}