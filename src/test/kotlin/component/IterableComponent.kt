package component

import com.microsoft.playwright.Locator
import extension.waitForElements

/**
 * A component that represents a collection of UI elements, each of which can be mapped to a specific component type.
 *
 * @param T The type of component that this iterable component contains.
 * @property root The root locator used to find the elements.
 * @property factory A function that creates a component of type T from a locator.
 */
class IterableComponent<T : Component>(
    private val root: Locator,
    private val factory: (Locator) -> T
) : Iterable<T> {

    override fun iterator(): Iterator<T> =
        root.waitForElements().getOrThrow().all().map { factory(it) }.iterator()

    fun findByText(text: String, extractor: (T) -> String?): T? =
        this.firstOrNull { extractor(it) == text }
}