package PlayWright_11_09_2025;

import org.testng.annotations.Test;

public class SampleTest extends BaseClass {

    @Test
    public void sampleLoginTest() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("swiftdemo", "Merc@123");

        BBPS_Electricity bbps = new BBPS_Electricity(page);
        bbps.openBBPSMenu();

        bbps.selectBBPSAdhoc();
    }
}