package com.ecommerce.pages;

import com.ecommerce.base.Base;
import com.ecommerce.driver.Driver;
import com.ecommerce.testDatas.TestData;
import com.ecommerce.utils.Utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends Base {
    Actions a = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

    List<String> names = new ArrayList<>();

    @FindBy(xpath = "//div[@class='heading cf']/button")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class='cartSection']/h3")
    public List<WebElement> productNames;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    List<WebElement> deleteButtons;

    @FindBy(xpath = "//div[@class='prodTotal cartSection']/p")
    List<WebElement> prices;

    @FindBy(xpath = "//div[@class='subtotal cf ng-star-inserted']/ul/li[2]/span[2]")
    public WebElement totalPrice;

    @FindBy(xpath = "//li[@class='totalRow'] //button[@class='btn btn-primary']")
    WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='overlay-container'] //div[@id='toast-container']")
    public static WebElement successMsg;

    @FindBy(xpath = "//div[@class='ng-star-inserted']/h1")
    public static WebElement noItemsInCartText;

    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public List<String> getProductNames(){
        for (WebElement productName : productNames) {
            System.out.println(productName.getText());
            names.add(productName.getText());
        }
        return names;
    }
    public int calculateTotalPrice(){
        int sum = 0;
        for (WebElement price : prices) {
            String text = price.getText().split(" ")[1];
            int value = Integer.parseInt(text);
            sum += value;
        }
        return sum;
    }

    public void deleteItemsInCart()  {
        for(int i = 0; i < productNames.size(); i++){
            if (TestData.productsToRemove.contains(productNames.get(i).getText())){
                a.moveToElement(deleteButtons.get(i)).click().build().perform();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public PaymentPage clickOnCheckoutButton(){
        Utilities.invisibilityOfElement(successMsg);
        a.scrollToElement(checkoutButton).build().perform();
        a.moveToElement(checkoutButton).build().perform();
        js.executeScript("arguments[0].scrollIntoView(true);",checkoutButton);
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        checkoutButton.click();
        return new PaymentPage();
    }
}
