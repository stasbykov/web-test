package component

import com.microsoft.playwright.Locator

/**
 * Abstract base class for UI components.
 *
 * This class provides a foundation for creating UI components with a root locator
 * and a name. It also provides a method to handle operations on the root locator.
 */

abstract class Component {

    protected abstract val root: Locator
    abstract val name: String

    /**
     * Executes a block of code with the component's root locator as the receiver.
     *
     * @param block The block of code to execute with the root locator as the receiver.
     * @return The result of the block execution.
     */
    fun <T> handle(block: Locator.() -> T): T {
        return block.invoke(root)
    }
}









