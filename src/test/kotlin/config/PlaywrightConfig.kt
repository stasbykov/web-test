package config

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.junit.Options
import com.microsoft.playwright.junit.OptionsFactory

/**
 * Playwright configuration class that implements [OptionsFactory] to provide
 * test configuration for browser launch options, context options, and browser name.
 *
 * This configuration:
 * - Uses Chromium browser
 * - Runs browser in headed mode (non-headless)
 * - Sets slow motion to 0 (no delay)
 * - Sets base URL to "https://practicesoftwaretesting.com/"
 */
class PlaywrightConfig : OptionsFactory {
    /**
     * Returns configured Playwright options for test execution.
     *
     * @return [Options] object with launch, context and browser configuration
     */
    override fun getOptions(): Options {
        return Options()
            .setLaunchOptions(
                BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(0.toDouble())
            )
            .setContextOptions(
                Browser.NewContextOptions().setBaseURL("https://practicesoftwaretesting.com/")
            )
            .setBrowserName("chromium")
    }
}
