package page

import block.PageBlock
import com.microsoft.playwright.Page

class ShopPageFactory(private val page: Page): PageFactory {
    override fun <T : PageBlock> create(content: T, navigation: (Page) -> Unit): ShopPage<T> =
        object : ShopPage<T>(page) {
            override val content = content
            override fun navigation(): ShopPage<T> {
                navigation.invoke(page)
                return this
            }
        }
}