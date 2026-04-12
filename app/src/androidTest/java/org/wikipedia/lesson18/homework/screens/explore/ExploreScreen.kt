package org.wikipedia.lesson18.homework.screens.explore

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object ExploreScreen : NamedScreen<ExploreScreen>() {

    override val screenName = "Экран Explore"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.name(withParent("Логотип"))
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
}

