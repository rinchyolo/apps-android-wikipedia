package org.wikipedia.lesson19.homework.screens.explore

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson19.homework.extensions.invokeWithText
import org.wikipedia.lesson19.homework.extensions.name
import org.wikipedia.lesson19.homework.utils.NamedScreen

object ExploreScreen : NamedScreen<ExploreScreen>() {

    override val screenName = "Экран Explore"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.name(withParent("Логотип"))
    }

    val tabMore by lazy {
        KTextView {
            withId(R.id.nav_tab_more)
        }.name(withParent("Таб More"))
    }

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::SearchItem)
                itemType(::CustomizeItem)
                itemType(::DayItem)
                itemType(::TopReadItem)
                itemType(::NewsItem)
                itemType(::FeaturedArticle)
            }
        ).name(withParent("Список виджетов"))
    }

    fun customizeBlock(fnc: CustomizeItem.() -> Unit) {
        items.invokeWithText("Customize", fnc)
    }

    fun topReadBlock(fnc: TopReadItem.() -> Unit) {
        items.invokeWithText("Top read", fnc)
    }
}

