package org.wikipedia.lesson26.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson11.homework.OnboardingScreen
import org.wikipedia.lesson26.classwork.ScreenshotStepOnlyFailInterceptor
import org.wikipedia.main.MainActivity
import java.util.Locale

class BeforeAfterTests : TestCase(Kaspresso.Builder.withForcedAllureSupport().apply {
    stepWatcherInterceptors.removeIf { it is ScreenshotStepInterceptor }
    stepWatcherInterceptors.add(ScreenshotStepOnlyFailInterceptor(screenshots))
    testRunWatcherInterceptors.add(MyTestRunWatcherInterceptor())
}) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkApplicationLanguageChange() {
        before("Проверка смены языка приложения") {
            device.language.switchInApp(Locale.FRENCH)
        }.after {
            device.language.switchInApp(Locale.ENGLISH)
        }.run {
            step("Проверяет, что язык переключен") {
                OnboardingScreen.skipButton.hasText("Sauter")
            }
        }
    }
}