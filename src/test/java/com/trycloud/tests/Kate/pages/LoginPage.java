package com.trycloud.tests.Kate.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "user")
    public WebElement userInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "submit-form")
    public WebElement submitButton;

    @FindBy(id = "lost-password")
    public WebElement forgotPassword;

    @FindBy(xpath = "//a[contains(text(),'Log in with a device')]")
    public WebElement loginWithDevice;
}
