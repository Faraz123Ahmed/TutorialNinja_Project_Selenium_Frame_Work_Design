package com.mymavenproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();  
        LoginPage.enteremail("faraz957.ahmed@gmail.com");
        LoginPage.enterpassword("A1faraz");
        LoginPage.ClickOnLoginButton();
        LoginPage.VerifyLoginSuccess();      

    }
    public static void enteremail(String email){
     WebElement emailField = driver.findElement(By.id("input-email"));
     emailField.sendKeys(email);

    }
    public static void enterpassword(String password){
        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys(password);
   
    }
    public static void ClickOnLoginButton(){
        WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        loginButton.click();
   
    }
    public static void VerifyLoginSuccess(){
       WebElement logoutlink = driver.findElement(By.linkText("Logout"));
       String text = logoutlink.getText();
       if(text.contains("Logout")){
         System.out.println("Login is Successful");

       }
       else{
        System.out.println("Login is failed");
       }

    }



}
