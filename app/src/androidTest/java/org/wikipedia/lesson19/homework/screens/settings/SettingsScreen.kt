package org.wikipedia.lesson19.homework.screens.settings

import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.invokeWithText
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object SettingsScreen : NamedScreen<SettingsScreen>() {

    override val screenName = "Экран Settings"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null


    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.recycler_view)
            },
            itemTypeBuilder = {
                itemType(::SettingsRecycler)
            }
        ).name(withParent("Список настроек"))
    }

    fun showLinkPreviewsBlock(fnc: SettingsRecycler.() -> Unit) {
        items.invokeWithText("Show link previews", fnc)
    }
}