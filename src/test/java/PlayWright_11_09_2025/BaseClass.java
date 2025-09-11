package PlayWright_11_09_2025;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setup(){
        playwright= Playwright.create();
        browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page= browser.newPage();

    }
    @AfterMethod
    public  void tearDown(){
        browser.close();
        playwright.close();
    }
}
