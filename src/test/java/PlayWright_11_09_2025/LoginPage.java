package PlayWright_11_09_2025;
import com.microsoft.playwright.Page;
public class LoginPage {
    private Page page;
    public LoginPage(Page page) {
        this.page = page;
    }
    public void login(String username, String password) {
        page.navigate("https://swiftqc.quicksekure.com/");
        page.fill("#txtUserName", username);
        page.fill("#txtPassword", password);
        page.click("#btnLogin");
        String otp = DBUtils.getOTP();
        page.waitForSelector("#txtOtp");
        page.fill("#txtOtp", otp);
        page.click("#btnOtpLogin");
    }
}
