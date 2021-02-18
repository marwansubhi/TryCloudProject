package com.trycloud.tests.Miray.pages;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement usernameInput() {
        return driver.findElement(By.xpath("//input[@id='user']"));
    }
    public WebElement passwordInput() {
        return driver.findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement loginButton() {
        return driver.findElement(By.xpath("//input[@id='submit-form']"));
    }


}









