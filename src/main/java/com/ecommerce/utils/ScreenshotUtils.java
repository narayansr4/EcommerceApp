package com.ecommerce.utils;

import com.ecommerce.base.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils extends Base {

    public static String captureScreenshot(String testcaseName){

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH.mm.ss");
        String formattedDate = dateTime.format(formatter);

        String path = System.getProperty("user.dir") + "\\screenshots\\" + testcaseName + formattedDate + ".png";
        TakesScreenshot sc = (TakesScreenshot)dr.get();
        File img = sc.getScreenshotAs(OutputType.FILE);

        File destFile = new File(path);
        try {
            FileHandler.copy(img,destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "../screenshots/" + testcaseName + formattedDate + ".png";
    }

}
