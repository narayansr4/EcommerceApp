package com.ecommerce.pages;

import com.ecommerce.base.Base;
import com.ecommerce.testDatas.TestData;
import com.ecommerce.utils.Utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Base {

    @FindBy(xpath = "//div[@class='card-body'] //h5/b")
    List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='card-body']/button[2]")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[@class='card-body']/button[1]")
    List<WebElement> viewButtons;

    @FindBy(css = "#res")
    WebElement productsCount;

    @FindBy(xpath = "//div[@class='overlay-container'] //div[@id='toast-container']")
    WebElement successMsg;

    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void addToCart()  {

        Utilities.invisibilityOfElement(successMsg);
        for (int i = 0; i < productNames.size(); i++){
            if (TestData.productsToAdd.contains(productNames.get(i).getText())){
                //Utilities.visibilityOfElement(addToCartButtons.get(i));
                js.executeScript("arguments[0].scrollIntoView(true);",addToCartButtons.get(i));
                Utilities.visibilityOfElement(addToCartButtons.get(i));
               // a.scrollToElement(addToCartButtons.get(i)).build().perform();
                //a.moveToElement(addToCartButtons.get(i)).click().build().perform();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                addToCartButtons.get(i).click();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Utilities.invisibilityOfElement(successMsg);
            }

        }

        a.scrollToElement(Utilities.cartBtn).build().perform();
        a.moveToElement(Utilities.cartBtn).build().perform();
    }

    public CartPage goToCartPage(){
        Utilities.cartBtn.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return  new CartPage();
    }

}
