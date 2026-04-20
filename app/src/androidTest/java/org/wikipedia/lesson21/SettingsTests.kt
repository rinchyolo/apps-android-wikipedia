package org.wikipedia.lesson21

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
import org.wikipedia.lesson20.homework.helpers.multiAction
import org.wikipedia.main.MainActivity

class SettingsTests : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun settingsTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen.tabMore.click()
            BottomSheet.settings.click()
            SettingsScreen.checkBoxById(0){
                checkBox.setChecked(true)
                checkBox.isChecked()
            }
            SettingsScreen.rightIconById(2){
                title.containsText( "Terms of use")
            }
        }
    }
}