package com.trycloud.tests.Marwan.pages;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
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
    @FindBy(xpath = " //*[@id='fileList']/tr[1]/td[2]/a/span[3]/a[2]")
    WebElement actionBar;

    @FindBy(xpath = "//*[@id='fileList']/tr[1]/td[2]/div/ul/li[3]/a/span[2]")
    WebElement addToFavorite;
    @FindBy(xpath = "//a[text()='Favorites']")
    WebElement favoritesTab;

    @FindBy(how = How.XPATH, using = "(//a[@aria-label='Files'])[1]")
    WebElement fileModuleButton;
    @FindBy(xpath = "//*[@class='button new']")
    WebElement plusSign;
    @FindBy(xpath = "//span[.='New folder']")
    WebElement newFolderTab;
    @FindBy(xpath = "//*[@id='view13-input-folder']")
    WebElement fileNameBox;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    WebElement submitAnewFileNameButton;
    @FindBy(how = How.XPATH, using = "//*[@id='fileList']/tr/td[2]/a/span/span")
    List<WebElement> allFilesCreated;

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

    public void createNewFolder(String folderName) {
        plusSign.click();
        BrowserUtils.sleep(2);
        newFolderTab.click();
        fileNameBox.sendKeys(folderName);
        submitAnewFileNameButton.click();
    }

    public boolean isNewFileDisplayed(String expectedFileName){
        boolean flag = false;
        for (WebElement each : allFilesCreated){
            if (each.getText().equals(expectedFileName)){
                flag = true;
                break;
            }
        }
        return flag;
    }


}
