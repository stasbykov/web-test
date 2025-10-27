package page

import block.PageBlock
import com.microsoft.playwright.Page

/**
 * Factory class for creating page objects with Playwright Page instance.
 *
 * This factory provides a centralized way to instantiate page objects
 * by injecting the shared Playwright Page instance into each page constructor.
 *
 * @property page The Playwright Page instance to be injected into page objects
 */
interface PageFactory {
    fun <T : PageBlock> create(content: T, navigation: (Page) -> Unit = {}): WebPage<T>
}