package PlayWright_11_09_2025;

import com.microsoft.playwright.Page;

public class BBPS_Electricity {
    private Page page;

    // XPaths
    private String bbpsCmsMenu = "xpath=//*[@id='MainMenu']/ul/li[7]/a";
    private String bbpsAdhoc = "//a[contains(text(),'BBPS ADHOC')]";
    private String Electricity = "//input[@id='ContentPlaceHolder1_DataListDashboardIcon_ImageButton1_12']";
    private String Elect_Selection = "//a[@class='chosen-single']";
    private String ConsumerNumber = "#ContentPlaceHolder1_txt_AccountNumber";
    private String DepositerName1 = "#ContentPlaceHolder1_txtDepositorName";
    private String DepositerMobile1 = "#ContentPlaceHolder1_txtDepositorMobile";
    private String Submit = "#ContentPlaceHolder1_btn_RegisterBeneficiary";
    private String Hybrid_RadioButton = "//input[@id='ContentPlaceHolder1_rbtn_latePayment']";
    private String Instant_Radio_Button = "//input[@id='ContentPlaceHolder1_rbtn_InstantPayment']";
    private String PayButton = "#ContentPlaceHolder1_btn_FundTransfer";
    private String OkButton = "//*[@id='alertify-ok']";

    public BBPS_Electricity(Page page) {
        this.page = page;
    }

    public void openBBPSMenu() {
        page.click(bbpsCmsMenu);
    }

    public void selectBBPSAdhoc() {
        page.waitForSelector(bbpsAdhoc);
        page.click(bbpsAdhoc);
        page.click(Electricity);
//        page.click(Elect_Selection);
    }

    public void performTransaction(String billerName, String accountNumber, String depositerName, String depositerMobile) {
        System.out.println("Processing biller: " + billerName);

        // ---------------- HYBRID Transaction ----------------
        page.click(Elect_Selection);
        page.click("//li[contains(text(),'" + billerName + "')]");
        page.fill(ConsumerNumber, accountNumber);
        page.fill(DepositerName1, depositerName);
        page.fill(DepositerMobile1, depositerMobile);
        page.click(Submit);
        page.click(Hybrid_RadioButton);
        page.click(PayButton);

        page.waitForSelector(OkButton);
        page.click(OkButton);

        page.waitForTimeout(3000); // wait 3s before next transaction
        page.click(Elect_Selection);

        // ---------------- INSTANT Transaction ----------------

        page.click("//li[contains(text(),'" + billerName + "')]");

        page.fill(ConsumerNumber, accountNumber);
        page.fill(DepositerName1, depositerName);
        page.fill(DepositerMobile1, depositerMobile);
        page.click(Submit);
        page.click(Instant_Radio_Button);
        page.click(PayButton);

        page.waitForSelector(OkButton);
        page.click(OkButton);
    }
}
