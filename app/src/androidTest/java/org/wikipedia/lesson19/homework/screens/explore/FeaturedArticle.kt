package org.wikipedia.lesson19.homework.screens.explore

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent

class
FeaturedArticle(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticle>(matcher) {

    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
            withText("Featured article")
        }.name(withParent("Название блока"))
    }

    val menu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Меню"))
    }

    val footerButton by lazy {
        KTextView(matcher) {
            withText("Today on Wikipedia")
        }.name(withParent("Текст с линком"))
    }

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.articleImage)
        }.name(withParent("Картинка"))
    }

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.articleTitle)
        }.name(withParent("Заголовок"))
    }

    val description by lazy {
        KTextView(matcher) {
            withId(R.id.articleDescription)
        }.name(withParent("Основной текст"))
    }

    val articleDivider by lazy {
        KView(matcher) {
            withId(R.id.articleDescription)
        }.name(withParent("Разделительная полоска"))
    }

    val articleExtract by lazy {
        KTextView(matcher) {
            withId(R.id.articleExtract)
        }.name(withParent("Подзаголовок"))
    }
}