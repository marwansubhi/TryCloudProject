package com.trycloud.tests.Miray.test;

import com.trycloud.tests.Miray.pages.LoginPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @Test
    public void LoginTest (){
        LoginPage loginPage =new LoginPage(driver);
        loginPage.usernameInput().sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordInput().sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton().click();
    }

}
