package component.table

import com.microsoft.playwright.Locator
import component.Component
import component.IterableComponent
import component.base.TextComponent
import component.navigation.ButtonComponent
import component.navigation.LinkComponent

/**
 * Cell component.
 *
 * @property root The root locator of the component.
 * @property name The name of the component.
 */
class CellComponent(
    override val root: Locator,
    override val name: String
) : Component() {

    fun asText() = TextComponent(root, "$name:Text")
    fun asButton() = ButtonComponent(root, "$name:Button")
    fun asLink() = LinkComponent(root, "$name:Link")

    // Nested list link
    fun asLinkList(): IterableComponent<LinkComponent> =
        IterableComponent(root.locator("a")) { locator ->
            LinkComponent(locator, "Link")
        }

    // Nested table
    fun asNestedTable(): TableComponent =
        TableComponent(root.locator("table"), "$name:NestedTable")
}