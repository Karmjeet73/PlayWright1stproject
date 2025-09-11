package PlayWright_11_09_2025;

import org.testng.annotations.Test;

public class SampleTest extends BaseClass {

    @Test
    public void testLoginWithOTP() throws InterruptedException {
        // Step 1: Navigate & login
        page.navigate("https://swiftqc.quicksekure.com/");
//        page.locator("text=Proceed").click();
        page.fill("#txtUserName", "swiftdemo");
        page.fill("#txtPassword", "Merc@123");
        page.click("#btnLogin");
        String otp = DBUtils.getOTP();
        System.out.println("OTP from DB = " + otp);
        page.waitForSelector("#txtOtp");
        page.fill("#txtOtp", otp);
        Thread.sleep(5000);
        page.click("#btnOtpLogin");
    }
}
