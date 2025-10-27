package page

import block.FooterBlock
import block.HeaderBlock
import block.PageBlock
import com.microsoft.playwright.Page

abstract class ShopPage<T : PageBlock>(page: Page): WebPage<T>() {
    val header = HeaderBlock(page)
    val footer = FooterBlock(page)
}