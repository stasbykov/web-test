package test

import block.ContentBlock
import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.Page
import com.microsoft.playwright.junit.UsePlaywright
import config.PlaywrightConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import page.ShopPage
import page.ShopPageFactory

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@UsePlaywright(PlaywrightConfig::class)
class ShopTest {

    private lateinit var webPage: ShopPage<ContentBlock>

    @BeforeEach
    fun setup(page: Page) {
        webPage = ShopPageFactory(page).create(ContentBlock(page)) { page.navigate("/") }
    }

    @AfterEach
    fun tearDown(page: Page, context: BrowserContext) {
        context.close()
        page.close()
    }

    @Test
    fun `should be show menu in header`() {
        webPage.navigation()
        val actualMenu = webPage.header.getMenu()
        assertThat(actualMenu).isEqualTo(listOf("Home", " Categories ", "Contact", "Sign in", " EN "))
    }

    @Test
    fun `should be show 'Pliers' in product list`() {
        webPage.navigation()
        val actualPliersImg = webPage.content.getProductImg(" Pliers ")
        val actualPliersPrice = webPage.content.getProductPrice(" Pliers ")
        val actualPliersCo2Ratings = webPage.content.getProductCo2Ratings(" Pliers ")
        assertThat(actualPliersImg).isEqualTo("assets/img/products/pliers02.avif")
        assertThat(actualPliersPrice).isEqualTo("$12.01")
        assertThat(actualPliersCo2Ratings).isEqualTo(listOf("A", "B", "C", "D", "E"))
    }
}