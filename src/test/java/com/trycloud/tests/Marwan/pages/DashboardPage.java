package com.trycloud.tests.Marwan.pages;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardPage extends TestBase {
    @FindBy(how = How.XPATH,using = "(//a[@aria-label='Dashboard'])[1]")
    WebElement dashboardButton;
    @FindBy(xpath = "(//a[@aria-label='Files'])[1]")
    WebElement filesButton;

    @FindBy(xpath = "//*[@id='fileList']/tr[2]/td[2]/div/ul/li[3]/a/span[2]")
    WebElement favorite;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
//    @Test
//    public void logInToTryCloud(){
//        LoginPage loginPage = new LoginPage();
//
//        loginPage.logIn(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
//
//        BrowserUtils.sleep(2);
//
//      //  driver.findElement(By.xpath("(//a[@aria-label='Files'])[1]")).click();
//        filesButton.click();
//    }

    public void clickFiles(){
        filesButton.click();
    }

    public void clickFavorite(){

        favorite.click();
    }
}
