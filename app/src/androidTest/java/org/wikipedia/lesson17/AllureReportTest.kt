package org.wikipedia.lesson17

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson11.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class AllureReportTest : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testForAllure() {
        run {
            step("Проверяет, что кнопка skip отображается") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Кликает на кнопку skip") {
                OnboardingScreen.skipButton.click()
            }
        }
    }

}