package component.base

import com.microsoft.playwright.Locator
import extension.waitForElements
import component.Component

/**
 * Image component.
 *
 * @property root The root locator of the component.
 * @property name The name of the component.
 */
class ImageComponent(
    override val root: Locator,
    override val name: String = "Image"
) : Component() {
    val src: String? get() = root.waitForElements().getOrNull()?.getAttribute("src")
    val alt: String? get() = root.waitForElements().getOrNull()?.getAttribute("alt")
}