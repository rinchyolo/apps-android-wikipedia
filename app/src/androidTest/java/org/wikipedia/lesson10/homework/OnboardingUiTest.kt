package org.wikipedia.lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkFirstScreen() {
        run("Проверяет отображение первого экрана онбординга") {
            step("Проверяет отображение элементов первого экрана онбординга") {
                OnboardingUiScreen {
                    image.isDisplayed()
                    skipButton.isDisplayed()
                    continueButton.isDisplayed()
                    addLanguageButton.isDisplayed()
                    languageLabel.containsText("English")
                    primaryText.containsText("The Free")
                    secondaryText.containsText("following on your")
                }
            }
        }
    }

    @Test
    fun checkContinueButton() {
        run("Проверяет переключение между экранами") {
            OnboardingUiScreen {
                step("Проверяет отображение элементов первого экрана онбординга") {
                    addLanguageButton.isDisplayed()
                    primaryText.containsText("The Free")
                    secondaryText.containsText("following on your")
                }
                step("Переключает на второй слайд экран онбординга") {
                    continueButton.click()
                }
                step("Проверяет, что открылся второй экран онбординга") {
                    primaryText.containsText("New ways")
                    secondaryText.containsText("Dive down")
                }
            }
        }
    }

    @Test
    fun checkFinishScreen() {
        run("Проверяет отображение кнопок для экрана онбординга") {
            OnboardingUiScreen {
                step("Переключает на финальный экран онбординга") {
                    repeat(3) {
                        continueButton.click()
                    }
                }
                step("Проверяет отображение финального экрана онбординга") {
                    primaryText.containsText("Data")
                    secondaryText.containsText("We believe")
                    getStartedButton.containsText("Get started")
                }
            }
        }
    }

    @Test
    fun checkAddLanguagesButton() {
        run("Проверяет, что при тапе на кнопку 'Add of edit laguages' выполняется переход на экран редактирования языков") {
            step("Выполняет тап на кнопку редактирования языков") {
                OnboardingUiScreen.addLanguageButton.click()
            }
            step("Проверяет, что выполнился переход на экран редактирования языков") {
                LanguagesUiScreen.sectionHeaderText.hasText("Your languages")
            }
        }
    }
}