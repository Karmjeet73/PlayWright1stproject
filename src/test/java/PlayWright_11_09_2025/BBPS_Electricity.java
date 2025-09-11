package PlayWright_11_09_2025;

import com.microsoft.playwright.Page;

public class BBPS_Electricity {
    private Page page;

    // XPaths
    private String bbpsCmsMenu = "xpath=//*[@id='MainMenu']/ul/li[7]/a";
    private String bbpsAdhoc = "xpath=//a[@class=\"level2 selected dynamic\"]";

    // ✅ Constructor name matches class name
    public BBPS_Electricity(Page page) {
        this.page = page;
    }

    // Open BBPS CMS menu
    public void openBBPSMenu() {
        page.click(bbpsCmsMenu);
    }

    // Select BBPS Adhoc option
    public void selectBBPSAdhoc() {
        page.waitForSelector(bbpsAdhoc); // waits until visible
        page.click(bbpsAdhoc);
    }
}
