package org.wikipedia.lesson22.homework

import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent
import org.wikipedia.R
import org.wikipedia.lesson22.KWidget

class ThemeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeWidget>(builder) {

    val sizePercentText by lazy {
        KTextView(matcher) {
            withId(R.id.text_size_percent)
        }.name(withParent("Размер текста"))
    }

    val increaseSizeButton by lazy {
        KButton(matcher) {
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Кнопка увеличения размера текста"))
    }

    val decreaseSizeButton by lazy {
        KButton(matcher) {
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Кнопка уменьшения размера текста"))
    }

    val chooserMatchSystem by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Переключатель системы матча темы"))
    }

    val themeDarkButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_dark)
        }.name(withParent("Кнопка включение dark темы"))
    }

    val themeBlackButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_black)
        }.name(withParent("Кнопка включение black темы"))
    }

}