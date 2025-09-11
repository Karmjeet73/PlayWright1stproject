package PlayWright_11_09_2025;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions()
                .setPermissions(java.util.List.of("geolocation"))); // allow location
        page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
