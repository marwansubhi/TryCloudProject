package com.trycloud.tests.Miray.test;

import com.trycloud.tests.Miray.pages.ContactModulePage;
import com.trycloud.tests.Miray.pages.HomePage;
import com.trycloud.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTestPage extends TestBase {

    @Test
    public void setHomePage() {
        LoginPageTest loginPageTest = new LoginPageTest();
        loginPageTest.LoginTest();
        HomePage homePage = new HomePage(driver);
        homePage.contactModuleButton().click();

        String expectedPageTitle = "Contacts";
        String actualPageTitle = driver.getTitle();

        Assert.assertTrue(expectedPageTitle.equals(actualPageTitle));

    }
}