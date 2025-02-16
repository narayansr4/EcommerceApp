package com.ecommerce.pages;

import com.ecommerce.base.Base;
import com.ecommerce.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {
    Actions a = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

    @FindBy(css = "input#userEmail")
    private WebElement email;

    @FindBy(css="input#userPassword")
    private WebElement password;

    @FindBy(css="input#login")
    public WebElement loginBtn;

    @FindBy(css="#toast-container")
    private WebElement successToast;

    @FindBy(xpath = "//a[@class='btn1']")
    private WebElement registerLink;

    @FindBy(css="a.forgot-password-link")
    public WebElement forgotPasswordlink;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getTitle(){
        return Driver.getDriver().getTitle();
    }

    public HomePage login(String email, String password){

        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginBtn.click();
        return new HomePage();
    }

    public RegisterPage clickOnRegisterLink() {

        a.moveToElement(registerLink).click().build().perform();
        //registerLink.click();
        return new RegisterPage();
    }
}
