package org.wikipedia.lesson11.homework

import androidx.appcompat.widget.AppCompatImageButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object CustomizeScreen : KScreen<CustomizeScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val backButton = KImageView {
        withParent { withId(R.id.toolbar) }
        isInstanceOf(AppCompatImageButton::class.java)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
            itemType(::CustomizeRecycler)
        }
    )


}