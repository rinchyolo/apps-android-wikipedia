package org.wikipedia.lesson10.homework

import androidx.appcompat.widget.AppCompatTextView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object LanguagesUiScreen : UiScreen<LanguagesUiScreen>() {

    override val packageName: String = "org.wikipedia.alpha"

    val sectionHeaderText = UiTextView {
        withId(this@LanguagesUiScreen.packageName, "section_header_text")
    }

    val languageTitle = UiTextView {
        withId(this@LanguagesUiScreen.packageName, "wiki_language_title")
    }

    val langCodeText = UiTextView {
        withId(this@LanguagesUiScreen.packageName, "langCodeText")
    }

    val languageOrder = UiTextView {
        withId(this@LanguagesUiScreen.packageName, "wiki_language_order")
    }
}