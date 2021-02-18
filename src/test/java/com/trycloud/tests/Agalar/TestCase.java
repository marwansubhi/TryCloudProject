package com.trycloud.tests.Agalar;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.testng.annotations.AfterMethod;

public class TestCase {
    @Test
    public void test01(){
        Driver.getDriver().get("http://qa.trycloud.net/index.php/login?clear=1");
        // we getting needed url to our browser


        TryCloudSighIn1 tryCloudSighIn1 = new TryCloudSighIn1();
        // we created already needen locateers in our constractor method to make it easy and less code to save memory

        // we finding locators and sending nedden keys values by properties files to be more secure our files
        tryCloudSighIn1.inputLogIn.sendKeys(ConfigurationReader.getProperty("username"));
        //we finding password locators and sending keys in to  it
        tryCloudSighIn1.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        //we finding log in buttom and clicking to it be sign in to website
        tryCloudSighIn1.logInButton.click();

        System.out.println("=================================================================");







    }

    @AfterMethod
    public void tearDownSystem() throws InterruptedException{


        Driver.getDriver().quit();
    }
}
