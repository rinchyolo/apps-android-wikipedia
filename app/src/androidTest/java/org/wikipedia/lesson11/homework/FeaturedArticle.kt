package org.wikipedia.lesson11.homework

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class
FeaturedArticle(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticle>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
        withText("Featured article")
    }

    val menu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val footerButton = KTextView(matcher) {
        withText("Today on Wikipedia")
    }

    val image = KImageView(matcher) {
        withId(R.id.articleImage)
    }

    val title = KTextView(matcher) {
        withId(R.id.articleTitle)
    }

    val description = KTextView(matcher) {
        withId(R.id.articleDescription)
    }

    val articleDivider = KView(matcher) {
        withId(R.id.articleDescription)
    }

    val articleExtract = KTextView(matcher) {
        withId(R.id.articleExtract)
    }
}