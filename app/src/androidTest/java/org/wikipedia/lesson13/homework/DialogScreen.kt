package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.R
import org.wikipedia.views.WikiCardView

object DialogScreen : KScreen<DialogScreen>() {

    override val layoutId = R.layout.dialog_on_this_day_game
    override val viewClass = WikiCardView::class.java

    val closeButton = KImageView {
        withId(R.id.closeButton)
    }
}