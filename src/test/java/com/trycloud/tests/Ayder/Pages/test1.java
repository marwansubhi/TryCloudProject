package com.trycloud.tests.Ayder.Pages;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class test1 extends TestBase {


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
}
