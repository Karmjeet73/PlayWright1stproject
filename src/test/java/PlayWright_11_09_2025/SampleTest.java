package PlayWright_11_09_2025;

import org.testng.annotations.Test;

public class SampleTest extends BaseClass {

    @Test
    public void sampleLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("swiftdemo", "Merc@123");

        BBPS_Electricity bbps = new BBPS_Electricity(page);
        bbps.openBBPSMenu();
        bbps.selectBBPSAdhoc();

        // 🔹 List of billers with sample account details
        String[][] billers = {
                {"ADANI ELECTRICITY MUMBAI LIMITED", "111111111", "Karmjeet Mor", "9729951696"},
//                {"BSES YAMUNA - DELHI", "222222222", "Rajender Singh", "9876543210"},
                {"BSES RAJDHANI - DELHI", "333333333", "Amit Sharma", "9998887776"},
//                {"DHBVN - HARYANA", "4444444444","9729951696", "Sunil Kumar", "9988776655"},
                {"TATA POWER – MUMBAI", "555555555555", "Rohit Verma", "9876543211"},
//                {"UTTAR HARYANA BIJLI VITRAN NIGAM", "666666666", "Anil Sharma", "9996665554"}
        };

        for (String[] data : billers) {
            bbps.performTransaction(data[0], data[1], data[2], data[3]);

            // ⏳ wait 4 seconds before moving to next biller
            Thread.sleep(4000);

            // ✅ Fetch latest transaction from DB for verification
            DBUtils.fetchLatestRechargeTxn();
        }
    }
}
