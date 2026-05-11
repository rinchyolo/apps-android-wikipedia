package org.wikipedia.lesson26.classwork

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson19.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.main.MainActivity

class SimpleTest : TestCase(Kaspresso.Builder.withForcedAllureSupport().apply {
    stepWatcherInterceptors.removeIf { it is ScreenshotStepInterceptor }
    stepWatcherInterceptors.add(ScreenshotStepOnlyFailInterceptor(screenshots))
}) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run {
            step("success") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("error") {
                OnboardingScreen.skipButton.isNotDisplayed()
            }
        }
    }

}