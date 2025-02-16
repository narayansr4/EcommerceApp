package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.*;
//import com.OrangeHrm.testComponents.Retry;
import com.ecommerce.utils.ExcelUtils;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
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

    @DataProvider(name = "paymentDetails")
    public String[][] getExcelData() throws IOException {
        String[][] data = ExcelUtils.getExcelData("PaymentDetails");
        return data;
    }

    @Test(dataProvider = "paymentDetails")
    public void verifyPayment(String cardNum, String cvv, String country) {
        Utilities util = new Utilities();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        homePage.addToCart();
        homePage.scrollToCartIcon();
        cartPage = homePage.goToCartPage();
        paymentPage = cartPage.clickOnCheckoutButton();

        orderConfirmPage = paymentPage.performPayment(cardNum,cvv,country);
        Assert.assertTrue(orderConfirmPage.thankYouLabel.isDisplayed());
    }


}
