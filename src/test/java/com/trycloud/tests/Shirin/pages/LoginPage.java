package com.trycloud.tests.Shirin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserNameField() {
        return driver.findElement(By.xpath("//*[@id='user']"));
    }
    public WebElement getPasswordField() {
        return driver.findElement(By.xpath("//*[@id='password']"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//*[@id='submit-form']"));
    }
}
