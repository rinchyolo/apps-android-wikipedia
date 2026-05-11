package org.wikipedia.lesson26.homework

import android.util.Log
import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewAssertionWatcherInterceptor

class CheckStartWatcherInterceptor : ViewAssertionWatcherInterceptor {

    override fun intercept(
        viewAssertion: ViewAssertion,
        view: View?,
        exception: NoMatchingViewException?
    ) {
        Log.d("KASPRESSO", "CHECK START: ${viewAssertion::class.java.simpleName}")
    }
}