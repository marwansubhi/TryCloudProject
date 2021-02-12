package com.trycloud.tests.Ella;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class US_7_User_Search_Items {

    String loginBox = "//input[@placeholder='Username or email']";
    String passwordBox = "//input[@placeholder='Password']";
    String loginButton = "//input[@value='Log in']";
    String searchIcon = "//div[@class='header-menu unified-search']";
    String searchInpBox = "//input[@type='search']";

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("urlQA2"));
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.getDriver().findElement(By.xpath(loginBox)).sendKeys(ConfigurationReader.getProperty("username1"));
        Driver.getDriver().findElement(By.xpath(passwordBox)).sendKeys(ConfigurationReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath(loginButton)).click();
    }

    @Test(description = "TC_1")
    public void search_any_files_folder_users_from_search_box() {
        Driver.getDriver().findElement(By.xpath(searchIcon)).click();
        Driver.getDriver().findElement(By.xpath(searchInpBox)).sendKeys("TryCloud");
        WebElement itemFound = Driver.getDriver().findElement(By.xpath("//h3/span/strong"));
        BrowserUtils.sleep(3);
        Assert.assertTrue(itemFound.getText().contains("TryCloud"), "File not found! FAILED!!!");

        BrowserUtils.sleep(3);

        Driver.getDriver().findElement(By.xpath(searchInpBox)).clear();
        Driver.getDriver().findElement(By.xpath(searchInpBox)).sendKeys("MyFolder");
        itemFound = Driver.getDriver().findElement(By.xpath("//h3/span/strong"));
        BrowserUtils.sleep(3);
        Assert.assertTrue(itemFound.getText().contains("MyFolder"), "Folder not found! FAILED!!!");

        BrowserUtils.sleep(3);

        Driver.getDriver().findElement(By.xpath(searchInpBox)).clear();
        Driver.getDriver().findElement(By.xpath(searchInpBox)).sendKeys("Muhtar");
        itemFound = Driver.getDriver().findElement(By.xpath("//h3/span/strong"));
        BrowserUtils.sleep(3);
        Assert.assertTrue(itemFound.getText().contains("Muhtar"), "User not found! FAILED!!!");

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }

}
