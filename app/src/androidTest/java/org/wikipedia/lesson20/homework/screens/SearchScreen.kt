package org.wikipedia.lesson20.homework.screens

import io.github.kakaocup.kakao.edit.KEditText
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object SearchScreen : NamedScreen<SearchScreen>() {
    override val screenName: String = "Экран поиска"
    override val layoutId = null
    override val viewClass: Class<*>? = null

    val searchField by lazy {
        KEditText {
            withId(androidx.appcompat.R.id.search_src_text)
        }.name(withParent("Поле поиска"))
    }
}