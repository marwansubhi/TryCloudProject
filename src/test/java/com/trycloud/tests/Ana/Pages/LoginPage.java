package com.trycloud.tests.Ana.Pages;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    @Test
    public void login() {
        Driver.getDriver().get(("http://qa2.trycloud.net"));
        BrowserUtils.sleep(2);

        //Enter valid username
        WebElement userInput = Driver.getDriver().findElement(By.xpath("//input[@id='user']"));
        //enter valid password
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        //click login button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@id='submit-form']"));

        userInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains("Trycloud"));

    }
}
