package org.wikipedia.lesson25.homework

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class SmartScenarios(private val testContext: TestContext<*>) {

    fun closePlayTodayGame() = ClosePlayTodayGame(testContext).initBehavior()
    fun closeGotIt() = CloseGotIt(testContext).initBehavior()
}

val TestContext<*>.smartScenarios: SmartScenarios
    get() = SmartScenarios(this)
