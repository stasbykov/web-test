package component.table

import com.microsoft.playwright.Locator
import component.Component
import component.IterableComponent
import component.base.TextComponent

/**
 * Table component.
 *
 * @property root The root locator of the component.
 * @property name The name of the component.
 */
class TableComponent(
    override val root: Locator,
    override val name: String = "Table"
) : Component() {
    val headers = IterableComponent(root.locator("thead th")) { locator ->
        TextComponent(locator, "Header")
    }

    val rows = IterableComponent(root.locator("tbody tr")) { locator ->
        RowComponent(locator, "Row")
    }
}