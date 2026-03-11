package org.wikipedia.lesson11.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.views.WikiErrorView
import org.wikipedia.R

object ErrorScreen : KScreen<ErrorScreen>() {

    override val layoutId = R.layout.view_wiki_error
    override val viewClass = WikiErrorView::class.java

    val icon = KImageView {
        withId(R.id.view_wiki_error_icon)
    }

    val text = KTextView {
        withId(R.id.view_wiki_error_text)
    }

    val button = KButton {
        withId(R.id.view_wiki_error_button)
    }
}