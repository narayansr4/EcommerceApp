package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.*;
import com.ecommerce.testComponents.Retry;
import com.ecommerce.utils.ExcelUtils;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyPaymentTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    PaymentPage paymentPage;
    OrderConfirmPage orderConfirmPage;

    public VerifyPaymentTest(){
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        initialize();
        Utilities util = new Utilities();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        homePage.addToCart();
        cartPage = homePage.goToCartPage();
        paymentPage = cartPage.clickOnCheckoutButton();
    }

    @DataProvider(name = "paymentDetails")
    public String[][] getExcelData() throws IOException {
        String[][] data = ExcelUtils.getExcelData("PaymentDetails");
        return data;
    }

    @Test(dataProvider = "paymentDetails",groups = {"smoke"}, retryAnalyzer = Retry.class)
    public void verifyPayment(String cardNum, String cvv, String country) {
        orderConfirmPage = paymentPage.performPayment(cardNum,cvv,country);
        Assert.assertTrue(orderConfirmPage.thankYouLabel.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        close();
//        getDriver().quit();
//        unload();
    }

}
