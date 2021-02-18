package com.trycloud.tests.alex.tests;

import com.trycloud.tests.alex.pages.HomePage;
import com.trycloud.tests.alex.pages.LogInPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US2_TC1_Users_Access_Main_Modules extends TestBase {


    /*
    Test case #1 - verify users access to the main modules
    1. Login as a user
    2. Verify the user see the following modules:
     Files
     Galleries
     Activity
    Talk
    Contacts
    Calendar
    Note
     ( Expected module name: Galleries
     Actual module name : Photos )
     */
    @Test
    public void TC1() {

        LogInPage logInPage = new LogInPage();

        String LogInTitle = driver.getTitle();

        Assert.assertTrue(LogInTitle.contains("Trycloud"));

        logInPage.LogIn(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));


        HomePage homePage = new HomePage();

        BrowserUtils.sleep(3);
        Assert.assertEquals(driver.getTitle(),"Dashboard - Trycloud");


        homePage.clickFileModule();

        BrowserUtils.sleep(3);
        Assert.assertEquals(driver.getTitle(), "Files - Trycloud");


        homePage.clickPhotosModule();

        BrowserUtils.sleep(3);
        Assert.assertEquals(driver.getTitle(), "Photos - Trycloud");


        homePage.clickActivityModule();

        BrowserUtils.sleep(3);
        Assert.assertEquals(driver.getTitle(), "Activity - Trycloud");

        homePage.clickTalkModule();

        BrowserUtils.sleep(3);
        Assert.assertEquals(driver.getTitle(),"Talk - Trycloud");

        homePage.clickContactsModule();

        BrowserUtils.sleep(3);
        Assert.assertEquals(driver.getTitle(),"Contacts - Trycloud");


        homePage.clickCalendarModule();

        BrowserUtils.sleep(3);
        Assert.assertTrue(driver.getTitle().contains("Calendar"),"Calendar - Trycloud");

        homePage.clickDeckModule();

        BrowserUtils.sleep(3);
        Assert.assertEquals(driver.getTitle(),"Deck - Trycloud");



    }


}
