package com.ecommerce.pages;

import com.ecommerce.base.Base;
import com.ecommerce.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmPage extends Base {
    Actions a = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

    @FindBy(xpath = "//h1[@class='hero-primary']")
    public WebElement thankYouLabel;

    public OrderConfirmPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
