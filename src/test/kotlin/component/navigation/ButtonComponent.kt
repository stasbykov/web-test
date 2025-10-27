package component.navigation

import com.microsoft.playwright.Locator
import extension.waitForElements
import component.Component

/**
 * Button component.
 *
 * @property root The root locator of the component.
 * @property name The name of the component.
 */
class ButtonComponent(override val root: Locator, override val name: String = "Button component") : Component() {
    val text: String? get() = root.waitForElements().getOrNull()?.textContent()
}