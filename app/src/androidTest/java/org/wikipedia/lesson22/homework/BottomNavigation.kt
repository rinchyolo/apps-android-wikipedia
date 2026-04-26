package org.wikipedia.lesson22.homework

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name

object BottomNavigation : NamedScreen<BottomNavigation>() {

    override val screenName = "Нижняя навигация"
    override val layoutId = null
    override val viewClass = null

    val themeNavigation by lazy {
        KTextView{
            withId(R.id.page_theme)
        }.name(withParent("Theme"))
    }

}
