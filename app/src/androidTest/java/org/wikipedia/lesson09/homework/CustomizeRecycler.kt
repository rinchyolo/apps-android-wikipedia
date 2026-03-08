package org.wikipedia.lesson09.homework

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeRecycler(matcher: Matcher<View>) : KRecyclerItem<CustomizeRecycler>(matcher) {

    val dragIcon = KImageView(matcher) {
        withId(R.id.feed_content_type_drag_handle)
    }

    val checkBox = KCheckBox(matcher) {
        withId(R.id.feed_content_type_checkbox)
    }

    val titleCheckBox = KTextView(matcher) {
        withId(R.id.feed_content_type_title)
    }

    val subtitleCheckBox = KTextView(matcher) {
        withId(R.id.feed_content_type_subtitle)
    }

}