package PageObjectModel_Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {

         WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
         

        //LoginPage lp = new LoginPage(driver);
        LoginPagewithFactory Lpwf = new LoginPagewithFactory(driver);

        driver.get("https://www.saucedemo.com/");
        Lpwf.enterusername("standard_user");
        Lpwf.enterpassword("secret_sauce");
        Lpwf.ClickOnLoginBtn();

    }

}
