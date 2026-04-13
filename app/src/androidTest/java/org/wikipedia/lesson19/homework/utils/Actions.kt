package org.wikipedia.lesson19.homework.utils

import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson18.homework.extensions.getName

class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }
}