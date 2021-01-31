package com.trycloud.tests.base;

import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws IOException {
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       Properties properties = new Properties();
       String path = "configuration.properties";
       FileInputStream file = new FileInputStream(path);
       properties.load(file);
       String url = properties.getProperty("url");
       driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
       driver.close();
       driver.quit();
    }

}