package block

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page
import component.Component
import component.IterableComponent
import component.base.ImageComponent
import component.base.TextComponent

/**
 * Content block representing the main content area of the shop page.
 *
 * This block contains product cards and provides methods to extract
 * information from them such as images, CO2 ratings, and prices.
 *
 * @property page The Playwright [Page] instance used to locate elements
 */
class ContentBlock(override val page: Page) : PageBlock {
    /**
     * Iterable component representing product cards on the page.
     * Each card contains an image, title, CO2 rating, and price.
     */
    private val productCards = IterableComponent(page.locator("a.card")) { el ->
        object: Component() {
            override val root: Locator
                get() = el
            override val name: String
                get() = "Product card"

            val img = ImageComponent(root.locator(".card-img-wrapper img"), "Image")
            val title = TextComponent(root.locator(".card-body h5"), "Title")
            val co2Rating = IterableComponent(root.locator(".co2-rating-scale span")) { el ->
                TextComponent(el, "CO2 rating")
            }
            val price = TextComponent(root.locator("[data-test='product-price']"), "Price")
        }
    }

    /**
     * Gets the image source for a product with the specified title.
     *
     * @param title The title of the product to find
     * @return The image source URL, or empty string if not found
     */
    fun getProductImg(title: String): String = productCards.findByText(title) { it.title.text }?.img?.src.orEmpty()

    /**
     * Gets the CO2 ratings for a product with the specified title.
     *
     * @param title The title of the product to find
     * @return List of CO2 rating values, or empty list if not found
     */
    fun getProductCo2Ratings(title: String): List<String> = productCards.findByText(title) { it.title.text }?.co2Rating?.map { it.text.orEmpty() } ?: emptyList()

    /**
     * Gets the price for a product with the specified title.
     *
     * @param title The title of the product to find
     * @return The product price, or empty string if not found
     */
    fun getProductPrice(title: String): String = productCards.findByText(title) { it.title.text }?.price?.text.orEmpty()
}