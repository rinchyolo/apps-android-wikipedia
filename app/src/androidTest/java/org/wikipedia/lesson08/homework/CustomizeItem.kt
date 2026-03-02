package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {

    val icon = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }

    val textSubtitle = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }

    val actionPositiveButton = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val actionNegativeButton = KButton(matcher) {
        withId(R.id.view_announcement_action_negative)
    }
}