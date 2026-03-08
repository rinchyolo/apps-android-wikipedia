package org.wikipedia.lesson09.homework

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.main.MainActivity

class WikipediaTest : TestCase() {

    @get:Rule
    val testResult = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkFeatureArticleIsNotVisibleOnExploreScreen() {
        run("Проверяет отключение блока Feature article на экране Explore") {
            step("Нажимает Skip на экране онбординга") {
                OnboardingScreen.skipButton.click()
            }
            step("Проверяет отображение блока Featured Article экрана Explore") {
                ExploreScreen.items {
                    childWith<FeaturedArticle> {
                        isInstanceOf(FeaturedArticleCardView::class.java)
                    } perform {
                        isDisplayed()
                    }
                }
            }
            step("Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore") {
                ExploreScreen.items {
                    childWith<CustomizeItem> {
                        isInstanceOf(AnnouncementCardView::class.java)
                    } perform {
                        actionPositiveButton.click()
                    }
                }
            }
            CustomizeScreen {
                items.childWith<CustomizeRecycler> {
                    withDescendant { withText("Featured article") }
                } perform {
                    step("Отключает Featured Article") {
                        checkBox.click()
                    }
                }
                step("Нажимает стрелку назад в верхнем тулбаре") {
                    backButton.click()
                }
            }
            step("Проверяет, что блок Featured Article не отображается на экране Explore (метод doesNotExist())") {
                ExploreScreen.items {
                    childWith<FeaturedArticle> {
                        isInstanceOf(FeaturedArticleCardView::class.java)
                    } perform {
                        header.doesNotExist()
                    }
                }
            }
        }
    }
}