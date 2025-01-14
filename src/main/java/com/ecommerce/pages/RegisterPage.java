package com.ecommerce.pages;

import com.ecommerce.base.Base;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Base {
    @FindBy(id="firstName")
    WebElement firstName;

    @FindBy(id="lastName")
    WebElement lastName;

    @FindBy(id="userEmail")
    WebElement email;

    @FindBy(id="userMobile")
    WebElement phoneNumber;

    @FindBy(css="select.custom-select.ng-untouched.ng-pristine.ng-valid")
    WebElement occupationDropdown;

    @FindBy(css="input[value='Male']")
    WebElement male;

    @FindBy(css="input[value='Female']")
    public WebElement female;

    @FindBy(id="userPassword")
    WebElement password;

    @FindBy(id="confirmPassword")
    WebElement confirmPassword;

    @FindBy(css="input[type='checkbox']")
    WebElement confirmAgeCheckbox;

    @FindBy(css="input#login")
    public WebElement registerBtn;

    @FindBy(css="a.text-reset")
    WebElement loginLink;

    @FindBy(xpath = "//div[contains(text(),'*Phone Number must be 10 digit')]")
    public WebElement phnNumberValidationMsg;

    @FindBy(xpath="//h1[text()='Account Created Successfully']")
    public WebElement successText;

    public RegisterPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void setOccupationDropdown(String occupation){
        Select dd = new Select(occupationDropdown);
        dd.selectByVisibleText(occupation);
    }
    public  void selectGender(String gender){
        if (gender.equalsIgnoreCase("Male")){
            male.click();
        }
        else if (gender.equalsIgnoreCase("Female")){
            female.click();
        }
        else System.out.println("Please select any gender");
    }

    public void registerUser(String fname, String lname, String email, String number, String occupation,String gender, String password, String confirmPassword){

        dr.get().manage().window().fullscreen();

        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        this.email.sendKeys(email);
        phoneNumber.sendKeys(number);
        setOccupationDropdown(occupation);
        selectGender(gender);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        confirmAgeCheckbox.click();
        a.moveToElement(registerBtn).click().build().perform();
        //registerBtn.click();

    }
}
