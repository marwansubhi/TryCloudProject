package com.trycloud.tests.Shirin.tests;

import com.trycloud.tests.Shirin.pages.LoginPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class TalkModuleTest extends TestBase {
    @Test
    public void accessToTalkModule() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUserNameField().sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.getPasswordField().sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.getLoginButton().click();
    }
}
