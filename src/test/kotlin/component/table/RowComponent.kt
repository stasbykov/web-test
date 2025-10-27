package component.table

import com.microsoft.playwright.Locator
import component.Component
import component.IterableComponent

/**
 * Row component.
 *
 * @property root The root locator of the component.
 * @property name The name of the component.
 */
class RowComponent(
    override val root: Locator,
    override val name: String
) : Component() {
    val cells = IterableComponent(root.locator("td")) { locator ->
        CellComponent(locator, "Cell")
    }
}