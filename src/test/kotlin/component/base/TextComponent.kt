package component.base

import com.microsoft.playwright.Locator
import extension.waitForElements
import component.Component

/**
 * Text component.
 *
 * @property root The root locator of the component.
 * @property name The name of the component.
 */
class TextComponent(override val root: Locator, override val name: String = "Text component") : Component() {
    val text: String? get() = root.waitForElements().getOrNull()?.textContent()
}