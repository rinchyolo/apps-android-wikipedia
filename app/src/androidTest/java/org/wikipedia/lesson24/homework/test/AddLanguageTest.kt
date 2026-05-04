package org.wikipedia.lesson24.homework.test

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson19.AddLanguageScreen
import org.wikipedia.lesson19.LanguageScreen
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.main.MainActivity

class CombinedAddLanguageTest : BaseTest() {

    @get:Rule(0)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule(1)
    val kakaoRule = KakaoComposeTestRule(composeTestRule, true)

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun verifyThatFrenchLanguageAdded() {
        run {
            action.click(OnboardingScreen.addLanguageButton)
            action.click(LanguageScreen.addLanguageButton)
            AddLanguageScreen().getFrenchItem {
                verify.assertTrimmedTextIsEquals(titleLanguage, "Français")
                verify.assertTrimmedTextIsEquals(subtitleLanguage, "French")
                action.clickIfEnabled(titleLanguage)
            }
            device.uiDevice.pressBack()
        }
    }
}