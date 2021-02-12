package com.trycloud.tests.alex.pages;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogInPage extends TestBase {


    WebElement userNameBox= driver.findElement( By.xpath("//input[@id='user']"));
    WebElement passwordBox= driver.findElement(By.cssSelector("input[id='password']"));

    WebElement loginButton = driver.findElement(By.xpath("//input[@id='submit-form']"));

    public   void LogIn(String userName, String password){

        userNameBox.sendKeys(userName);
        passwordBox.sendKeys(password);
        BrowserUtils.sleep(3);
        loginButton.click();




    }



}
