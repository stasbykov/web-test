package block

import com.microsoft.playwright.Page

/**
 * Base interface for page blocks that provides access to the Playwright [Page] instance.
 *
 * Page blocks represent distinct sections or components of a web page (e.g., header, footer, content area)
 * and serve as containers for UI components within those sections.
 *
 * @property page The Playwright [Page] instance associated with this block
 */
interface PageBlock {
    val page: Page
}