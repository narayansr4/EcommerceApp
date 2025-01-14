package com.ecommerce.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

//import static java.time.Duration.ofSeconds;

public class Base {

    public  static Properties prop;
    private static WebDriver driver;
    public static Actions a;

    public static JavascriptExecutor js;

    protected static  ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static  WebDriver getDriver(){

        return dr.get();
    }

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static void unload(){
        dr.remove();
    }

    public Base()  {
        prop = new Properties();
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\ecommerce\\config\\config.properties";
        FileInputStream fis = null;
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

    public static void initialize(){
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            System.out.println("--------Chrome Browser Started--------");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions(); //getting error in Jenkins for Edge
            options.addArguments("headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            driver = new EdgeDriver(options);
            //driver = new EdgeDriver();
            System.out.println("--------Edge Browser Started--------");
        }

        setDriver(driver);
        a = new Actions(getDriver());
        js = (JavascriptExecutor)getDriver();
        getDriver().get(prop.getProperty("url"));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public static void close(){
        getDriver().quit();
        System.out.println("--------Browser Closed--------");
        unload();
    }

}
