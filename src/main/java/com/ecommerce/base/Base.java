package com.ecommerce.base;

import com.ecommerce.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static Properties prop;
    public static WebDriver driver;
    public Base() {
        prop = new Properties();
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\ecommerce\\config\\config.properties";
        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public static  void initialize(){
        Driver.initDriver();
    }

    @AfterMethod
    public static void close(){
        Driver.quitDriver();
    }

}
