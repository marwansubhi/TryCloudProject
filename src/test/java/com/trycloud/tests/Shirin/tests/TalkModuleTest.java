package com.trycloud.tests.Shirin.tests;

import com.trycloud.tests.Shirin.pages.LoginPage;
import com.trycloud.tests.Shirin.pages.TalkModulePage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class
TalkModuleTest extends TestBase {
    @Test
    public void accessToTalkModule() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUserNameField().sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.getPasswordField().sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.getLoginButton().click();
        loginPage.getTalkButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(),"Talk - Trycloud");


    }
    @Test
    public void sendMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUserNameField().sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.getPasswordField().sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.getLoginButton().click();
        loginPage.getTalkButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        TalkModulePage talkModulePage = new TalkModulePage(driver);
       // talkModulePage.getSearchBox().click();
      talkModulePage.getUser("User101");
      String message = "Hello Batch21";
      talkModulePage.writeMessage(message);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        for (int i = 0; i < 5; i++) {
            try{
                talkModulePage.getSubmitButton().click();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }



      Thread.sleep(2000);

      Assert.assertEquals(talkModulePage.getLastMessage(),message);



    }
}
