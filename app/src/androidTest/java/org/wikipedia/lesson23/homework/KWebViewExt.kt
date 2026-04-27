package org.wikipedia.lesson23.homework

import io.github.kakaocup.kakao.web.KWebView

fun KWebView.withXpath(xpath: String): KWebViewElement {
    return KWebViewElement(
        webView = this,
        xpath
    )
}