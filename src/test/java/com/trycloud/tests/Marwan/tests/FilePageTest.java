package com.trycloud.tests.Marwan.tests;

import com.trycloud.tests.Marwan.pages.FilePage;
import com.trycloud.tests.Marwan.pages.LoginPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FilePageTest extends TestBase {
    LoginPage loginPage ;
    FilePage filePage ;

    @Test(priority = 1)
    public void verify_page_title(){
        loginPage = new LoginPage();
        filePage= new FilePage() ;
        loginPage.logIn(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(5);
        String expectedPageTitle = "Files - Trycloud - QA";
        String actualPageTitle = filePage.getTitleOfLogInPage();
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
    }
    @Test(priority = 2)
    public void user_can_select_all_uploaded_files(){
        loginPage = new LoginPage();
        loginPage.logIn(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        filePage = new FilePage();
        BrowserUtils.sleep(5);
        filePage.selectAllFiles();
        Assert.assertTrue(filePage.areAllFilesSelected());

    }

    /*
    @Test
    public void myTest(){
        loginPage = new LoginPage();
        loginPage.logIn(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        filePage = new FilePage();
        filePage.selectAllFiles();
        BrowserUtils.sleep(5);
        List<WebElement> list = driver.findElements(By.xpath("//input[contains(@id,'select-files')]"));
        list.forEach(p->{
            System.out.println(p.isSelected());
        });

     */
        /*
        System.out.println(driver.findElement(By.xpath("//*[@id='select-files-6274']/following-sibling::label")).isSelected());
        driver.findElement(By.xpath("//*[@for='select_all_files']")).click();// this is to check if at least one file is selected

         */

    }

