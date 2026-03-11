package org.wikipedia.lesson11.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.main.MainActivity
import java.util.Locale

class WikipediaTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkRotateDevice() {
        run("Проверяет возможность поворота экрана") {
            step("Поворачивает экран") {
                device.uiDevice.setOrientationLeft()
            }
            step("Проверяет, что экран повернулся") {
                val actual = device.uiDevice.isNaturalOrientation
                val expected = false
                Assert.assertEquals(expected, actual)
            }
        }
    }

    @Test
    fun checkTurnOffDevice() {
        run("Проверяет включение и выключение девайса") {
            step("Выключает экран девайса") {
                device.uiDevice.sleep()
            }
            step("Включает экран девайса") {
                device.uiDevice.wakeUp()
            }
            step("Проверяет, что приложение активно") {
                OnboardingScreen.skipButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkHideApplication() {
        run("Проверяет возможность сворачивания и разворачивания приложения") {
            step("Сворачивает приложение") {
                device.uiDevice.pressHome()
            }
            step("Разворачивает приложение") {
                device.uiDevice.pressRecentApps()
                Thread.sleep(300)
                device.uiDevice.pressRecentApps()
            }
            step("Проверяет, что на экране отображается skip button") {
                OnboardingScreen.skipButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkArticleLoadOfflineRetryOnline() {
        run("Проверяет возможность работы приложения с выключенным wifi") {
            run {
                step("Выключает сеть") {
                    device.network.toggleMobileData(false)
                    device.network.toggleWiFi(false)
                }
                step("Переходит в статью") {
                    OnboardingScreen.skipButton.click()
                    ExploreScreen.items {
                        childWith<FeaturedArticle> {
                            isInstanceOf(FeaturedArticleCardView::class.java)
                        } perform {
                            image.click()
                        }
                    }
                }
                step("Проверяет отображение экрана с ошибкой") {
                    ErrorScreen {
                        icon.isDisplayed()
                        text.containsText("error")
                        button.isDisplayed()
                    }
                }
                step("Включает сеть") {
                    device.network.toggleMobileData(true)
                    device.network.toggleWiFi(true)
                }
                step("Тапает на кнопку 'Go back'") {
                    ErrorScreen.button.click()
                }
                step("Проверяет отображение экрана после включения сети") {
                    ExploreScreen.items {
                        childWith<FeaturedArticle> {
                            isInstanceOf(FeaturedArticleCardView::class.java)
                        } perform {
                            image.isDisplayed()
                        }
                    }
                }
            }
        }
    }

    @Test
    fun checkApplicationLanguageChange() {
        run("Проверка смены языка приложения") {
            step("Переключает язык приложения на французский") {
                device.language.switchInApp(Locale.FRENCH)
                Thread.sleep(300)
            }
            step("Проверяет, что язык переключен") {
                OnboardingScreen.skipButton.hasText("Sauter")
            }
        }
    }

    @Test
    fun checkCurrentActivity() {
        run("Проверяет, что главное активити после онбординга - MainActivity") {
            step("Скипает онбординг, чтобы попасть на MainActivity") {
                OnboardingScreen.skipButton.click()
                Thread.sleep(300)
            }
            step("Проверяет, что сейчас отображается MainActivity") {
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }
}