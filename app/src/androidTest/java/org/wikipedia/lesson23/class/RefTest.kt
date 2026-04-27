package org.wikipedia.lesson23.`class`

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.homework.DialogScreen
import org.wikipedia.lesson19.homework.extensions.action
import org.wikipedia.lesson19.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson19.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson23.homework.ArticleScreen
import org.wikipedia.main.MainActivity

class RefTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun refTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                item(0) {
                    action.click(this)
                }
            }
            action.click(DialogScreen.closeButton)
            ArticleScreen {
                step("Проверяет заголовок") {
                    title.performWebViewAction {
                        scroll()
                        hasText("Nahui Ollin")
                    }
                }
                references {
                    step("Проверка отображения списка") {
                        performWebViewAction {
                            scroll()
                            click()
                            Thread.sleep(3000)
                        }
                    }
                }

                referenceItem(1) {
                    step("Проверка отображения индекса") {
                        index.performWebViewAction {
                            scroll()
                            hasText("[1]")
                        }
                    }
                }
            }
        }
    }
}