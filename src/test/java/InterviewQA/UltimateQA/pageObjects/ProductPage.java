package InterviewQA.UltimateQA.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;

    private WebElement getShoppingCartElement(){
        return driver.findElement(By.cssSelector(".shopping_cart_link"));
    }

    public void openShoppingCart(){
        getShoppingCartElement().click();
    }
}
