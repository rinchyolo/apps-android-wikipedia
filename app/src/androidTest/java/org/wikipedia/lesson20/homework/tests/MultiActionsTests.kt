package org.wikipedia.lesson20.homework.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson19.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson19.homework.screens.more.BottomSheet
import org.wikipedia.lesson19.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.screens.settings.SettingsScreen
import org.wikipedia.lesson20.homework.helpers.equalsWithTrim
import org.wikipedia.lesson20.homework.helpers.multiAction
import org.wikipedia.lesson20.homework.screens.SearchScreen
import org.wikipedia.main.MainActivity

class MultiActionsTests : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen.searchBlock {
                hint.click()
            }
            SearchScreen {
                searchField.click()
                searchField.multiAction()
                searchField.equalsWithTrim("On")
                device.uiDevice.pressBack()
                device.uiDevice.pressBack()

            }
            ExploreScreen.tabMore.click()
            BottomSheet.settings.click()
            SettingsScreen.downloadOnlyOverWiFiBlock {
                checkBox.click()
                checkBox.isChecked()
            }
        }
    }
}