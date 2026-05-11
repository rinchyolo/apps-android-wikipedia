package org.wikipedia.lesson25.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.homework.DialogScreen
import org.wikipedia.lesson19.homework.extensions.action
import org.wikipedia.lesson19.homework.extensions.verify
import org.wikipedia.lesson19.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson19.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson22.homework.BottomNavigation
import org.wikipedia.lesson22.homework.BottomSheet
import org.wikipedia.main.MainActivity

class SmartScenarioTest : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun changeFontSizeTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.featuredArticleBlock {
                action.click(this)
            }
            smartScenarios.closePlayTodayGame()
            action.click(BottomNavigation.themeNavigation)
            BottomSheet.themeWidget {
                action.click(increaseSizeButton)
                verify.hasText(sizePercentText, "110%")
                action.click(decreaseSizeButton)
            }
        }
    }
}