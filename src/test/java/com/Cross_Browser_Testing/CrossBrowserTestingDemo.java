package com.Cross_Browser_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestingDemo {

    WebDriver driver;

@BeforeMethod
@Parameters("browser")
public void LaunchBrowser(String browser){
   switch(browser.toLowerCase()){
    case "chrome":
    driver = new ChromeDriver();
    break;
   
    case "msedge":
    driver = new EdgeDriver();
    break;

    default:
    driver =null;
    break;

   }


}


@Test
public void verifyTitle(){
  driver.get("http://www.google.com");
  String ExpectedTitle = "Google";
  String ActualTitle = driver.getTitle();

  Assert.assertEquals(ExpectedTitle,ActualTitle);

}

@AfterMethod
public void Quit(){

    driver.quit();
}

}
