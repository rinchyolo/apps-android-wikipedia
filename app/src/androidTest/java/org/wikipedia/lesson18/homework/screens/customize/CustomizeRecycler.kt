package org.wikipedia.lesson18.homework.screens.customize

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent

class CustomizeRecycler(matcher: Matcher<View>) : KRecyclerItem<CustomizeRecycler>(matcher) {

    val dragIcon = KImageView(matcher) {
        withId(R.id.feed_content_type_drag_handle)
    }.name(withParent("Картинка"))

    val checkBox by lazy {
        KCheckBox(matcher) {
            withId(R.id.feed_content_type_checkbox)
        }.name(withParent("Чекбокс"))
    }

    val titleCheckBox by lazy {
        KTextView(matcher) {
            withId(R.id.feed_content_type_title)
        }.name(withParent("Заголовок"))
    }

    val subtitleCheckBox by lazy {
        KTextView(matcher) {
            withId(R.id.feed_content_type_subtitle)
        }.name(withParent("Подзаголовок"))
    }

}