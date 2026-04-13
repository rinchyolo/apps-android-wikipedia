package org.wikipedia.lesson19.homework.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson19.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson19.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extensions.action
import org.wikipedia.lesson19.homework.extensions.verify
import org.wikipedia.lesson19.homework.screens.more.BottomSheet
import org.wikipedia.lesson19.homework.screens.settings.SettingsScreen
import org.wikipedia.main.MainActivity

class WikipediaTests : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkThirdImageOnTopReadBlock() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                item(2) {
                    verify.isDisplayed(image)
                }
            }
        }
    }

    @Test
    fun shouldTurnOffShowLinkPreviewsBlock() {
        run {
            action.click(OnboardingScreen.skipButton)
            action.click(ExploreScreen.tabMore)
            action.click(BottomSheet.settings)
            SettingsScreen.showLinkPreviewsBlock {
                action.click(this)
                verify.isNotSelected(checkBox)
            }
        }
    }
}