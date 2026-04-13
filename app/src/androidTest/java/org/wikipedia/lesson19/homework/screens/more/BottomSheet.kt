package org.wikipedia.lesson19.homework.screens.more

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object BottomSheet : NamedScreen<BottomSheet>() {

    override val screenName: String = "Bottom sheet More"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val settings by lazy {
        KTextView {
            withText(R.string.settings_item_preferences)
        }.name(withParent("Настройки"))
    }
}