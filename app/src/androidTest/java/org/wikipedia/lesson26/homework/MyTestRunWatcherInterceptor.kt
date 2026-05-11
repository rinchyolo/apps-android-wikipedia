package org.wikipedia.lesson26.homework

import android.util.Log
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class MyTestRunWatcherInterceptor() : TestRunWatcherInterceptor {

    override fun onTestStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "LOG: TEST STARTED")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "LOG: BEFORE SECTION STARTED")
    }

    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "LOG: BEFORE SECTION FINISHED SUCCESS")
    }

    override fun onMainSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "LOG: MAIN SECTION STARTED")
    }

    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "LOG: MAIN SECTION FINISHED SUCCESS")
    }

    override fun onAfterSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "LOG: AFTER SECTION STARTED")
    }

    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "LOG: AFTER SECTION FINISHED SUCCESS")
    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        Log.i("KASPRESSO", "LOG: TEST FINISHED")
    }
}