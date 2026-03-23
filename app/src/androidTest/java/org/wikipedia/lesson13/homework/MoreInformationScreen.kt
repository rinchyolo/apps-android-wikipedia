package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object MoreInformationScreen : KScreen<MoreInformationScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val readArticleButton = KButton {
        withId(R.id.link_preview_primary_button)
    }

    val openInNewTabButton = KButton {
        withId(R.id.link_preview_secondary_button)
    }
}