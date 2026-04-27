package org.wikipedia.lesson23.homework

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.R

object ArticleScreen : NamedScreen<ArticleScreen>() {

    override val screenName = "Экран статьи"
    override val layoutId = null
    override val viewClass = null

    private val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val title by lazy {
        webView.withXpath("//h1")
            .name(withParent("Заголовок"))
    }

    val references by lazy {
        webView.withXpath("//h2[@id = 'References']")
            .name(withParent("Заголовок References"))
    }

    val referencesList by lazy {
        KWebViewList(webView, "//ol")
            .name(withParent("Список"))
    }

    fun referenceItem(position: Int, fnc: ReferenceItem.() -> Unit) {
        referencesList.childAt(position, fnc)
    }
}