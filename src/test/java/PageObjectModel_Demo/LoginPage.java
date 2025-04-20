package PageObjectModel_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//With out PageFactory

public class LoginPage {

WebDriver driver;

LoginPage(WebDriver d)
{
  driver = d;

}
 By Username = By.id("user-name");
 By Password = By.id("password");
 By LoginButton = By.id("login-button");

 public void enterusername(String username){
   driver.findElement(Username).sendKeys(username);

 }
 public void enterpassword(String password){
  driver.findElement(Password).sendKeys(password);

}

public void ClickOnLoginBtn(){
  driver.findElement(LoginButton).click();

}


}
