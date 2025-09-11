package PlayWright_11_09_2025;

import org.testng.annotations.Test;

public class SampleTest extends  BaseClass {
    @Test
    public  void testSearch(){
        page.navigate("https://swiftqc.quicksekure.com/");
        page.fill("#txtUserName","swiftdemo");
        page.fill("#txtPassword","Merc@123");


    }
}
