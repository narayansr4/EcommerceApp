package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.utils.ExcelUtils;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterUserExcelTest extends Base {

    LoginPage loginPage;
    RegisterPage registerPage;
    public RegisterUserExcelTest(){
        super();
    }

    @DataProvider(name = "userInfo")
    public String[][] getData() throws IOException {

        String[][] data = ExcelUtils.getExcelData("RegisterUsers");
        return  data;
    }

    @Test(dataProvider = "userInfo")
    public void validateRegisterUserExcel(String fname, String lname, String email, String number, String occupation,String gender, String password, String confirmPassword){
        loginPage = new LoginPage();
        registerPage = loginPage.clickOnRegisterLink();


        registerPage.registerUser(fname,lname,email,number,occupation,gender,password,confirmPassword);
        Assert.assertTrue(registerPage.successText.isDisplayed());
    }

}
