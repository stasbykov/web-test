package page

import block.PageBlock

abstract class WebPage<T : PageBlock> {
    abstract val content: T
    abstract fun navigation(): WebPage<T>
}



