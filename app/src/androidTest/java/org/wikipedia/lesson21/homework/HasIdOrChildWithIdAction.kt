package org.wikipedia.lesson21.homework

import android.view.View
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

class HasIdOrChildWithIdAction(private val resourceId: Int) : ViewAction {

    private var result = false

    override fun getDescription() = "Check that view contains view with specified resource id"

    override fun getConstraints(): Matcher<View> = ViewMatchers.isAssignableFrom(View::class.java)

    override fun perform(uiController: UiController?, view: View?) {
        if (view == null) throw IllegalStateException("View not submitted")
        if (view.id == resourceId) {
            result = true
        } else {
            val foundView = view.findViewById<View>(resourceId)
            result = foundView != null
        }
    }

    fun getResult() = result
}

fun BaseActions.hasIdOrChildWithId(resourceId: Int): Boolean {
    val hasIdOrChildWithIdIdAction = HasIdOrChildWithIdAction(resourceId)
    view.perform(hasIdOrChildWithIdIdAction)
    return hasIdOrChildWithIdIdAction.getResult()
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndResId(
    index: Int,
    resourceId: Int,
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
            val isElementWithId = hasIdOrChildWithId(resourceId)
            if (isElementWithId && counter++ == index) {
                name(recycler.getName().withParent(name))
                function()
                return
            }
        }
    }
}