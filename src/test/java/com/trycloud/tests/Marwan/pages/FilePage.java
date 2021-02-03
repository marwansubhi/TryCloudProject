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
    @FindBy(xpath = "(//span[@class='fileactions'])[2]/a[2]/span")
    WebElement actionBar;

    @FindBy(xpath = "//*[@data-id='6274' and@data-type='dir']/td[2]/div/ul/li[3]")
    WebElement favorite;
    @FindBy(xpath = "//a[text()='Favorites']")
    WebElement favoritesTab;


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

    public void selectActions(){
        actionBar.click();
    }

    public FavoritePage clickFavoriteBar(){
        favorite.click();
        return new FavoritePage();
    }
    public void clickFavoriteTab(){
        favoritesTab.click();
    }


}
