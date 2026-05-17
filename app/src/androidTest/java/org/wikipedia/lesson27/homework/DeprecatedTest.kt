package org.wikipedia.lesson27.homework

import android.util.Log
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class DeprecatedTest : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {

    @get:Rule
    val testRule = DeprecatedTestRule()

    @Test
    @Deprecated("Deprecated test")
    fun firstTest() {
        Log.i("KASPRESSO", "first log test")
    }

    @Test
    fun secondTest() {
        Log.i("KASPRESSO", "second log test")
    }

    @Test
    fun thirdTest() {
        Log.i("KASPRESSO", "third log test")
    }
}