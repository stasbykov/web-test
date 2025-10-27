package extension

import com.microsoft.playwright.Locator
import com.microsoft.playwright.options.WaitForSelectorState
import kotlin.runCatching
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

fun Locator.waitForElements(timeout: Duration = 10.seconds): Result<Locator> = runCatching {
    this.first().waitFor(
        Locator.WaitForOptions()
            .setState(WaitForSelectorState.VISIBLE)
            .setTimeout(timeout.inWholeMilliseconds.toDouble())
    )
    this
}
