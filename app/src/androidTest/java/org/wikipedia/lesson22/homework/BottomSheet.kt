package org.wikipedia.lesson22.homework

import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.lesson18.homework.extensions.name
import com.google.android.material.R as MaterialR

object BottomSheet : NamedScreen<BottomSheet>() {

    override val screenName = "Нижний оверлей"
    override val layoutId = null
    override val viewClass = null

    val themeWidget by lazy {
        ThemeWidget {
            withId(MaterialR.id.design_bottom_sheet)
        }.name(withParent("Виджет изменения темы"))
    }

}
