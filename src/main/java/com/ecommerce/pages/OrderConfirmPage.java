package com.ecommerce.pages;

import com.ecommerce.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmPage extends Base {

    @FindBy(xpath = "//h1[@class='hero-primary']")
    public WebElement thankYouLabel;

    public OrderConfirmPage(){
        PageFactory.initElements(getDriver(),this);
    }
}
