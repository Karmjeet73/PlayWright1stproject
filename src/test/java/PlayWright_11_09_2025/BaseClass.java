package PlayWright_11_09_2025;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;

public class BaseClass {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        context = browser.newContext(new Browser.NewContextOptions()
                .setPermissions(java.util.List.of("geolocation"))); // allow location
        page = context.newPage();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        page.setViewportSize(screenSize.width, screenSize.height);
    }

    @AfterMethod
    public void tearDown() {
        try {
            // wait for 10 seconds before closing
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        browser.close();
        playwright.close();
    }
}
