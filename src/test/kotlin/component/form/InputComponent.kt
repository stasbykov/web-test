package component.form

import com.microsoft.playwright.Locator
import extension.waitForElements
import component.Component

/**
 * Input component.
 *
 * @property root The root locator of the component.
 * @property name The name of the component.
 */
class InputComponent(override val root: Locator, override val name: String = "Input component") : Component() {
    val placeholder: String? get() = root.waitForElements().getOrNull()?.getAttribute("placeholder")
    val type: String? get() = root.waitForElements().getOrNull()?.getAttribute("type")
    val valueAttr: String? get() = root.waitForElements().getOrNull()?.getAttribute("value")
    val nameAttr: String? get() = root.waitForElements().getOrNull()?.getAttribute("name")
}