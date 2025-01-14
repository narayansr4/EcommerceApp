package com.ecommerce.utils;

import com.ecommerce.base.Base;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities extends Base {

    @FindBy(xpath="//button[@routerlink='/dashboard/']")
    public static WebElement homeBtn;

    @FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
    public static WebElement ordersBtn;

    @FindBy(xpath="(//button[@class='btn btn-custom'])[3]")  //new ------
    public static WebElement cartBtn;

    @FindBy(xpath="(//button[@class='btn btn-custom'])[4]")
    public static WebElement signOutBtn;

    @FindBy(css = "button[class='btn btn-custom'] label")
    public static WebElement cartCount;

    public Utilities() {
        PageFactory.initElements(getDriver(), this);
    }

    public static int getCartCount(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        a.moveToElement(cartCount).build().perform();
        String count =  Utilities.cartCount.getText();
        return Integer.parseInt(count);
    }

    public static  void visibilityOfElement(WebElement e){
        WebDriverWait wait = new WebDriverWait(dr.get(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(e));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }
    public  static void invisibilityOfElement(WebElement e){
        WebDriverWait wait = new WebDriverWait(dr.get(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.invisibilityOf(e));
    }

    public static String generateAlphabetsString(){
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
                .build();
        return generator.generate(8);
    }
    public static String generateAlphanumericString(){
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .build();
        return generator.generate(8);
    }
    public static String generateNumbersString(){
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', '9')
                .build();
        return generator.generate(9);
    }







}
