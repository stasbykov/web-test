package block

import com.microsoft.playwright.Page
import component.IterableComponent
import component.navigation.LinkComponent

/**
 * Header block representing the header section of the web page.
 *
 * This block contains the main navigation menu and provides methods
 * to interact with header elements.
 *
 * @property page The Playwright [Page] instance used to locate elements
 */
class HeaderBlock(override val page: Page) : PageBlock {
    /**
     * Iterable component representing the navigation menu items.
     * Each menu item is wrapped in a [LinkComponent].
     */
    private val menu = IterableComponent(page.locator(".nav-link")) { el ->
        LinkComponent(
            el,
            name = "Shop menu item"
        )
    }

    /**
     * Gets the text content of all menu items in the header.
     *
     * @return List of menu item texts, empty strings for items without text
     */
    fun getMenu(): List<String> = menu.map {
        it.text.orEmpty()
    }
}