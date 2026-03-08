package org.wikipedia.lesson09.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.onboarding.OnboardingPageView

object OnboardingScreen : KScreen<OnboardingScreen>() {

    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = OnboardingPageView::class.java

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }
}
