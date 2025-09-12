package PlayWright_11_09_2025;

import com.microsoft.playwright.Page;

public class BBPS_Electricity {
    private Page page;

    // XPaths
    private String bbpsCmsMenu = "xpath=//*[@id='MainMenu']/ul/li[7]/a";
    private String bbpsAdhoc = "//a[contains(text(),'BBPS ADHOC')]";
    private String Electricity ="//input[@id='ContentPlaceHolder1_DataListDashboardIcon_ImageButton1_12']";
    private String Elect_Selection="//a[@class='chosen-single']";
//    private String search="//input[@type='text']";
//    private String search_selection="//li[@class='active-result result-selected']";
;;


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
        // Wait & click BBPS Adhoc
        page.waitForSelector(bbpsAdhoc);
        page.click(bbpsAdhoc);

        // Select Electricity option
        page.click(Electricity);

        // Open provider selection dropdown
        // Click dropdown to open
        page.click(Elect_Selection);

// Type biller name into search input
        page.click("//li[contains(text(),'BSES RAJDHANI - DELHI')]");


        // OR if you still need to click the search result after Enter
        // page.click(search_selection);
    }}


//*[@id="ContentPlaceHolder1_ddlBillerName"]

