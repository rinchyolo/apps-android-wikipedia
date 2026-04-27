package org.wikipedia.lesson19.homework.utils

import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson18.homework.extensions.getName
import org.wikipedia.lesson23.homework.KWebViewElement


class Verify(private val steps: StepDefinitions) : StepsDsl<Verify>() {

    override val self = this

    fun isDisplayed(element: BaseAssertions) {
        steps.isDisplayed(
            "Проверяет, что отображается '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun hasText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' эквивалентен '$text'",
            element,
            text,
            false
        )
    }

    fun containsText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' содержит подстроку '$text'",
            element,
            text,
            true
        )
    }

    fun doesNotExist(element: BaseAssertions) {
        steps.doesNotExist(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' отсутствует",
            element
        )
    }

    fun isNotChecked(element: CheckableAssertions) {
        steps.isNotChecked(
            "Проверяет, что чекбокс '${(element as BaseActions).getName()}' не активен",
            element
        )
    }

    fun isEnabled(element: BaseAssertions) {
        steps.isEnabled(
            "Проверяет, что '${(element as BaseActions).getName()} доступен для взаимодействия'",
            element
        )
    }

    fun isDisabled(element: BaseAssertions) {
        steps.isDisabled(
            "Проверяет, что '${(element as BaseActions).getName()} недоступен для взаимодействия'",
            element
        )
    }

    fun isDisplayed(element: KWebViewElement) {
        steps.isDisplayed(
            "Проверяет, что '${(element as BaseActions).getName()} видим'",
            element
        )
    }
}