package com.trycloud.tests.Marwan.tests;

import com.trycloud.tests.Marwan.pages.FilePage;
import com.trycloud.tests.Marwan.pages.LoginPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void loginAsAUser(){
        loginPage = new LoginPage();
        loginPage.logIn(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
       // loginPage.clickPasswordLink();


        String expectedTitle = "Dashboard - Trycloud QA";
        String actualTitle =  loginPage.getTitleOfLogInPage();
        Assert.assertEquals(expectedTitle,(actualTitle));
    }

}
