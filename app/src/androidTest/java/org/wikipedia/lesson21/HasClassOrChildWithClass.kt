package org.wikipedia.lesson21

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.hamcrest.Matcher
import org.wikipedia.lesson18.homework.extensions.getName
import org.wikipedia.lesson18.homework.extensions.name
import kotlin.math.min

class HasClassOrChildWithClass(private val expectedClass: Class<out View>) : ViewAction {

    private var result = false

    override fun getDescription() = "Check that view has class or contains view with class"

    override fun getConstraints(): Matcher<View> = ViewMatchers.isAssignableFrom(View::class.java)

    override fun perform(uiController: UiController?, view: View?) {
        result = view?.let {
            checkInnerViewsClassContains(it, expectedClass)
        } ?: throw IllegalStateException("View not submitted")
    }

    private fun checkInnerViewsClassContains(view: View, expectedClass: Class<out View>): Boolean {
        if (expectedClass.isAssignableFrom(view::class.java)) return true
        if (view is ViewGroup) {
            view.children.forEach {
                if (checkInnerViewsClassContains(it, expectedClass)) return true
            }
        }
        return false
    }

    fun getResult() = result
}

fun BaseActions.hasClassOrChildWithClass(clazz: Class<out View>): Boolean {
    val hasClassOrChildWithClass = HasClassOrChildWithClass(clazz)
    view.perform(hasClassOrChildWithClass)
    return hasClassOrChildWithClass.getResult()
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    clazz: Class<out View>,
    limit: Int,
    startWith: Int = 0,
    name: String = "$index",
    function: T.() -> Unit
) {
    val recycler = this
    val numberOfElements = recycler.getSize()
    val lastIndex = min(limit, numberOfElements - 1)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementWithClass = hasClassOrChildWithClass(clazz)
            if (isElementWithClass && counter++ == index) {
                name(recycler.getName().withParent(name))
                function()
                return
            }
        }
    }
}