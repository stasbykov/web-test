package component.navigation

import com.microsoft.playwright.Locator
import extension.waitForElements
import component.Component

/**
 * Link component.
 *
 * @property root The root locator of the component.
 * @property name The name of the component.
 */
class LinkComponent(override val root: Locator, override val name: String = "Link component") : Component() {
    val text: String? get() = root.waitForElements().getOrNull()?.textContent()
    val href: String? get() = root.waitForElements().getOrNull()?.getAttribute("href")
    val target: String? get() = root.waitForElements().getOrNull()?.getAttribute("target")
}