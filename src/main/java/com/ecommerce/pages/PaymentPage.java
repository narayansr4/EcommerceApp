package com.ecommerce.pages;

import com.ecommerce.base.Base;
import com.ecommerce.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PaymentPage extends Base {
    Actions a = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

    @FindBy(xpath = "//div[@class='payment']/div[1]")
    public WebElement paymentLabel;

    @FindBy(xpath="//div[@class='payment__cc'] //input[@class='input txt text-validated']")
    public static WebElement cardNumber;

    @FindBy(xpath="(//input[@class='input txt'])[1]")
    WebElement cvv;

    @FindBy(xpath = "//select[@class='input ddl'][1]")
    WebElement monthDropdown;

    @FindBy(xpath = "//select[@class='input ddl'][2]")
    WebElement dayDropdown;

    @FindBy(xpath="(//input[@class='input txt'])[2]")
    WebElement cardName;

    @FindBy(xpath="//input[@name='coupon']")
    WebElement coupon;

    @FindBy(xpath="//button[@type='submit']")
    WebElement applyCouponBtn;

    @FindBy(xpath="//input[contains(@class,'input txt text-validated ng-untouche')]")
    WebElement email;

    @FindBy(xpath="//div[@class='form-group']/input")
    WebElement country;

    @FindBy(xpath = "//section[contains(@class,'ta-results')] //span[@class='ng-star-inserted']")
    List<WebElement> countryNames;

    @FindBy(xpath="//section[contains(@class,'ta-results')]")
    WebElement autoSuggestionBox;

    @FindBy(xpath="//a[contains(@class,'btnn action__submit')]")
    WebElement placeOrderBtn;

    @FindBy(xpath = "//div[@class='overlay-container'] //div[@id='toast-container']")
    public WebElement successMsg;

    public PaymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void selectMonth(String month){
        Select dd = new Select(monthDropdown);
        dd.selectByVisibleText(month);
    }

    public void selectDay(String day){
        a.moveToElement(dayDropdown).build().perform();
        Select dd = new Select(dayDropdown);
        dd.selectByVisibleText(day);
    }

    public void selectCountry(String country){
        this.country.sendKeys(country);
        for (WebElement countryName : countryNames) {
            if (countryName.getText().equalsIgnoreCase(country)){
                countryName.click();
            }
        }
    }

    public OrderConfirmPage performPayment(String cardNum, String cvv, String country) {

        cardNumber.clear();
        cardNumber.sendKeys(cardNum);
        this.cvv.sendKeys(cvv);
        selectCountry(country);
        //selectDay(day);
        //selectMonth(month);
        a.scrollToElement(placeOrderBtn).build().perform();
        a.moveToElement(placeOrderBtn).click().build().perform();
        return new OrderConfirmPage();
    }
}
