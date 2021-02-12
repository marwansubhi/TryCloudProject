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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US_3_User_Able_Access_Files {
    String loginBox = "//input[@placeholder='Username or email']";
    String passwordBox = "//input[@placeholder='Password']";
    String loginButton = "//input[@value='Log in']";
    String files = "//ul[@id='appmenu']//li[2]";
    String plusIcon = "//span[@class='icon icon-add']";

    String uploadFile = "//input[@type='file']";
    /*
    1.Login as a user
    2.Click the “+” icon on top
    3.Click “upload file”
     4.Upload a file
     5.Verify the file is displayed on the page
     */

    @BeforeMethod

    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("urlQA2"));
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.getDriver().findElement(By.xpath(loginBox)).sendKeys(ConfigurationReader.getProperty("username"));
        Driver.getDriver().findElement(By.xpath(passwordBox)).sendKeys(ConfigurationReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath(loginButton)).click();
    }

    @Test(description = "verify users can upload a file directly to the homepage (File-Uploading)")
    public void TC_5() {
        Driver.getDriver().findElement(By.xpath(files)).click();
        Driver.getDriver().findElement(By.xpath(plusIcon)).click();
        String filePath = "/Users/elvirakochkarova/Desktop/Document1.docx";
        Driver.getDriver().findElement(By.xpath(uploadFile)).sendKeys(filePath);
        BrowserUtils.sleep(7);

        List<WebElement> tableData = Driver.getDriver().findElements(By.xpath("//tbody[@id='fileList']//tr"));
        String data = "";
        for (WebElement eachElement : tableData) {
            data += eachElement.getText();
        }

        BrowserUtils.sleep(5);
        Assert.assertTrue(data.contains("Document1"), "Fail! File was not uploaded");
    }
    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }
}
