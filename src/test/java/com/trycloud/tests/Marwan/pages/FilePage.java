package com.trycloud.tests.Marwan.pages;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class FilePage extends TestBase {
    // Page factory, object repository
    @FindBy(xpath = "//*[@for='select_all_files']")
    WebElement selectAllCheckbox;
    @FindBy(how = How.XPATH, xpath = "//input[contains(@id,'select-files')]")
    List<WebElement> allFilesCheckBoxes;
    @FindBy(xpath = " //*[@id='fileList']/tr[3]/td[2]/a/span[2]/a[2]/span[1]")
    WebElement actionBar;

    @FindBy(xpath = "//*[@id='fileList']/tr[3]/td[2]/div/ul/li[3]/a/span[2]")
    WebElement addToFavorite;
    @FindBy(xpath = "//a[text()='Favorites']")
    WebElement favoritesTab;

    @FindBy(how = How.XPATH, using = "(//a[@aria-label='Files'])[1]")
    WebElement fileModuleButton;

/*
    //*[@id="fileList"]/tr[2]/td[2]/a/span[1]/span[1]
    //*[@id="fileList"]/tr[2]/td[2]/a/span[2]/a[2]/span[1]
    //*[@id="fileList"]/tr[1]/td[2]/a/span[3]/a[2]/span[1]
    //*[@id="fileList"]/tr[2]/td[2]/a/span[2]/a[2]/span[1]
    //*[@id="fileList"]/tr[3]/td[2]/a/span[2]/a[2]/span[1]
    //*[@id="fileList"]/tr[2]/td[2]/div/ul/li[3]/a/span[2]

    //*[@id='fileList']/tr[3]/td[2]/a/span[2]/a[2]/span[1]
 */




    public FilePage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitleOfLogInPage() {
        return driver.getTitle();
    }

    public void selectAllFiles() {
        selectAllCheckbox.click();
    }

    public boolean areAllFilesSelected() {
        boolean flag = false;
        for (WebElement eachFile : allFilesCheckBoxes) {
            if (eachFile.isSelected()) flag = true;
            else flag = false;
        }
        return flag;
    }

    public void selectActions() {
        actionBar.click();
    }

    public FavoritePage clickFavoriteBar() {
        addToFavorite.click();
        return new FavoritePage();
    }

    public void clickFavoriteTab() {
        favoritesTab.click();
    }



}
