package com.trycloud.tests.Marwan.pages;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage extends TestBase {

    // Page factory, object repository

    @FindBy(xpath = "//input[@id='user']")
    WebElement username;
    @FindBy(css = "input[id='password']")
    WebElement password;
    @FindBy(css = "input[id='submit-form']")
    WebElement loginButton;
    @FindBy(xpath = "//a[@id='lost-password']")
    WebElement forgotPasswordLink;
    @FindBy(xpath = "//*[@id='body-login']/div[1]/div/main/div/div/a[2]")
    WebElement logInWithADevice;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String getTitleOfLogInPage(){
        return driver.getTitle();
    }



    public FilePage logIn(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        return new FilePage();
    }


    public void clickPasswordLink(){
        forgotPasswordLink.click();
    }



}
