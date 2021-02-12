package com.trycloud.tests.Marwan.tests;

import com.trycloud.tests.Marwan.pages.DashboardPage;
import com.trycloud.tests.Marwan.pages.FavoritePage;
import com.trycloud.tests.Marwan.pages.FilePage;
import com.trycloud.tests.Marwan.pages.LoginPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FilePageTest extends TestBase {
    LoginPage loginPage;
    FilePage filePage;
    DashboardPage dashboard;
    FavoritePage favoritePage;
    WebDriverWait wait;

    @Test(priority = 1)
    public void verify_page_title() {
        loginPage = new LoginPage();
        dashboard = new DashboardPage();
        filePage = new FilePage();

        loginPage.logIn(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(5);
        dashboard.clickFiles();
        String expectedPageTitle = "Files - Trycloud QA";
        String actualPageTitle = filePage.getTitleOfLogInPage();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @Test(priority = 2)
    public void user_can_select_all_uploaded_files() {
        loginPage = new LoginPage();
        dashboard = new DashboardPage();
        filePage = new FilePage();


        loginPage.logIn(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));


        dashboard.clickFiles();
        BrowserUtils.sleep(5);
        filePage.selectAllFiles();
        Assert.assertTrue(filePage.areAllFilesSelected());

    }

    @Test(priority = 3)
    public void user_can_add_file_toFavorite() {
        loginPage = new LoginPage();
        dashboard = new DashboardPage();
        filePage = new FilePage();


        loginPage.logIn(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        dashboard.clickFiles();

        BrowserUtils.sleep(3);
        filePage.selectActions();
        filePage.clickFavoriteBar();
        BrowserUtils.sleep(3);
        filePage.clickFavoriteTab();

    }

    @Test(priority = 4)
    public void user_can_remove_file_from_favorite() {
        loginPage = new LoginPage();
        dashboard = new DashboardPage();
        filePage = new FilePage();
        favoritePage = new FavoritePage();

        loginPage.logIn(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        dashboard.clickFiles();

        BrowserUtils.sleep(3);

        filePage.clickFavoriteTab();

        BrowserUtils.sleep(3);

        favoritePage.clickAction();
        BrowserUtils.sleep(3);

        favoritePage.removeFile();
        driver.navigate().refresh();


        Assert.assertFalse(favoritePage.allFavoriteFolderTexts().contains("Java Package"));
    }

    @Test
    public void user_can_upload_file_directly_toTheHomepage(){
        loginPage = new LoginPage();
        filePage = new FilePage();
        dashboard = new DashboardPage();
        loginPage.logIn(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));

        dashboard.clickFiles();
        BrowserUtils.sleep(2);
        filePage.createNewFolder("Java Script");
        driver.navigate().refresh();
        BrowserUtils.sleep(3);
        String expectedFileName = "Java Script";

        Assert.assertTrue(filePage.isNewFileDisplayed(expectedFileName));

    }

/*
    @Test
    public void myTest() {
        loginPage = new LoginPage();
        loginPage.logIn(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        filePage = new FilePage();
//        filePage.selectAllFiles();
//        BrowserUtils.sleep(5);
//        List<WebElement> list = driver.findElements(By.xpath("//input[contains(@id,'select-files')]"));
//        list.forEach(p -> {
//            System.out.println(p.isSelected());
//        });
        driver.findElement(By.xpath("(//span[@class='fileactions'])[2]/a[2]/span")).click(); // click actions of third file
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath("//*[@data-id='6274' and@data-type='dir']/td[2]/div/ul/li[3]/a/span[2]")).click();// to click favorite
        filePage.clickFavoriteTab();
        FavoritePage favoritePage = new FavoritePage();
        System.out.println(favoritePage.isLocated());
    }

 */

}

