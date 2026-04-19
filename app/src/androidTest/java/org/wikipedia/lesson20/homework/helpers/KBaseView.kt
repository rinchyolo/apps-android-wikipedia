package org.wikipedia.lesson20.homework.helpers

import io.github.kakaocup.kakao.common.views.KBaseView

fun KBaseView<*>.multiAction() {
    view.perform(MultiAction("On"))
}