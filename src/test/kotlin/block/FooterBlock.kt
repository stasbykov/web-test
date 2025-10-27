package block

import com.microsoft.playwright.Page
import component.base.TextComponent

/**
 * Footer block representing the footer section of the web page.
 *
 * This block contains footer information text and provides methods
 * to interact with footer elements.
 *
 * @property page The Playwright [Page] instance used to locate elements
 */
class FooterBlock(override val page: Page) : PageBlock {
    /**
     * Text component representing the footer information paragraph.
     */
    private val info = TextComponent(page.locator("app-footer p"))

    /**
     * Gets the text content of the footer information.
     *
     * @return The footer text content, or empty string if not found
     */
    fun getInfo(): String = info.text.orEmpty()
}