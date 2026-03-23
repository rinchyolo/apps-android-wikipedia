package org.wikipedia.lesson13.homework

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson11.homework.ExploreScreen
import org.wikipedia.lesson11.homework.FeaturedArticle
import org.wikipedia.lesson11.homework.OnboardingScreen
import org.wikipedia.main.MainActivity


class WebViewTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
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
            step("Закрывает диалоговое окно") {
                DialogScreen.closeButton.click()
                Thread.sleep(300)
            }
            ArticleScreen {
                webView {
                    step("Скроллит до заголовка References и проверяет текст") {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
                    step("Переходит до 5 ссылки в тексте и кликает на нее") {
                        withElement(
                            Locator.XPATH,
                            "//sup[contains(@class, 'mw-ref')]//span[text()=5]"
                        ) {
                            click()
                        }
                    }
                }
            }
            step("Проверяет на соответствие текст заголовка") {
                ReferencesScreen.title.hasText("Reference ")
            }
            step("Проверяет, что номер в строке 5") {
                ReferencesScreen.refId.hasText("5.")
            }
            step("Закрывает всплывающее окно") {
                device.uiDevice.pressBack()
            }
            step("Тапает на вторую ссылку с CSS классом mw-redirect") {
                ArticleScreen.webView {
                    withElement(
                        Locator.XPATH,
                        "//*[contains(@class, 'mw-redirect')][2]"
                    ) {
                        click()
                    }
                }
            }
            step("Нажимает на кнопку Read Article"){
                MoreInformationScreen.readArticleButton.click()
            }
            step("Скроллит скроллить до элемента с id 'References'"){
                ArticleScreen.webView {
                    withElement(Locator.ID, "References") {
                        scroll()
                        hasText("References")
                    }
                }
            }
        }
    }

}