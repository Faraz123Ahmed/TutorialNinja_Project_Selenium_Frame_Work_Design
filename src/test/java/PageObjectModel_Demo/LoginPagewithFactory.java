package PageObjectModel_Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//With PageFactory
public class LoginPagewithFactory {

    WebDriver driver;

LoginPagewithFactory(WebDriver d)
{
  driver = d;
 PageFactory.initElements(driver, this);
 
}

  @FindBy(id="user-name")
  WebElement Username;

  @FindBy(id="password")
  WebElement Password;

  @FindBy(id="login-button")
  WebElement loginbutton;

  public void enterusername(String username){
    Username.sendKeys(username);
 
  }
  public void enterpassword(String password){
   Password.sendKeys(password);
 
 }
 
 public void ClickOnLoginBtn(){
   loginbutton.click();
 
 }


}
