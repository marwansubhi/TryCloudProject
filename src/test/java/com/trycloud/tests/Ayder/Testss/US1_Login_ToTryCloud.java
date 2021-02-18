package com.trycloud.tests.Ayder.Testss;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US1_Login_ToTryCloud extends TestBase {

    @Test
    public void test_LoginAndPassword() {

        WebElement userNameBox = driver.findElement(By.xpath("//*[@id='user']"));
        WebElement passwordBox = driver.findElement(By.xpath("//*[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='submit-form']"));

        userNameBox.sendKeys("User11");
        BrowserUtils.sleep(2);
        passwordBox.sendKeys("Userpass123");
        BrowserUtils.sleep(2);
        loginButton.click();
        BrowserUtils.sleep(8);



    }

    public void tearDown() {
        driver.close();
        driver.quit();

    }

}