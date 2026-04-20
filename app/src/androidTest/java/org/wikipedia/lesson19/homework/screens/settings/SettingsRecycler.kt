package org.wikipedia.lesson19.homework.screens.settings

import android.view.View
import com.google.android.material.materialswitch.MaterialSwitch
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extensions.name
import org.wikipedia.lesson18.homework.extensions.withParent

class SettingsRecycler(matcher: Matcher<View>) : KRecyclerItem<SettingsRecycler>(matcher) {

    val title = KTextView(matcher) {
        withId(R.id.title)
    }.name(withParent("Текст"))

    val summary by lazy {
        KTextView(matcher) {
            withId(android.R.id.summary)
        }.name(withParent("Описание"))
    }

    val checkBox by lazy {
        KCheckBox(matcher) {
            withId(R.id.switchWidget)
        }.name(withParent("Чекбокс"))
    }
}