package InterviewQA.UltimateQA.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    //url = https://www.saucedemo.com
    // another url = https://automationintesting.online/

    // private driver for a page object so that it's never accessible to our tests.
    private WebDriver driver;

    // private element locator that is never open to our tests.
    private WebElement getUserNameField(){
        return driver.findElement(By.id("user-name"));
    }
    private WebElement getPasswordField(){
        return driver.findElement(By.id("password"));
    }
    private WebElement clickLogin(){
        return driver.findElement(By.id("login-button"));
    }



    public void login(String userName, String password){
        getUserNameField().sendKeys(userName);
        getPasswordField().sendKeys(password);
        clickLogin().click();
    }


}
