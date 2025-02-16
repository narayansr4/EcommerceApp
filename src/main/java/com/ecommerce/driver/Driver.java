package com.ecommerce.driver;

import com.ecommerce.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver extends Base {
    public static WebDriver driver;
    private  static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return dr.get();
    }
    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }
    public static void unload(){
        dr.remove();
    }
    public static void initDriver(){
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            setDriver(driver);
            System.out.println("chrome opened");
        }
        getDriver().get(prop.getProperty("url"));
        System.out.println(getDriver().getTitle());
        getDriver().manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static void quitDriver(){
        getDriver().quit();
        unload();

    }
}
