package org.wikipedia.lesson26.homework

import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

abstract class BaseUiTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple().apply {
        viewBehaviorInterceptors.add(LogBeforeAfterInterceptor())
        // viewBehaviorInterceptors.add(BrokenInterceptor()) // только для задания 2

        viewAssertionWatcherInterceptors.add(CheckStartWatcherInterceptor())
        viewAssertionWatcherInterceptors.add(AssertFailureWatcherInterceptor())

        viewBehaviorInterceptors.add(ActionTimeInterceptor())
    }
)