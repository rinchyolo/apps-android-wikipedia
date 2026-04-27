package org.wikipedia.lesson23.homework

import io.github.kakaocup.kakao.web.KWebView

class ReferenceItem(
    kWebView: KWebView,
    listContainerXpath: String
) : KWebViewItem(kWebView, listContainerXpath) {

    override val self = this

    val index by lazy {
        child("//a[@class = 'pcs-ref-back-link']")
            .name(withParent("Индекс"))
    }
}