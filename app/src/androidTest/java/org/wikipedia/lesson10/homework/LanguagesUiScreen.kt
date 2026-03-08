package org.wikipedia.lesson10.homework

import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object LanguagesUiScreen : UiScreen<LanguagesUiScreen>() {

    override val packageName: String = "org.wikipedia.alpha"

    val sectionHeaderText = UiTextView {
        withId(this@LanguagesUiScreen.packageName, "section_header_text")
    }

}