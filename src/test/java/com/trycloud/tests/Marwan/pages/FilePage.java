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

    public FilePage(){
        PageFactory.initElements(driver,this);
    }

    public String getTitleOfLogInPage() {
        return driver.getTitle();
    }

    public void selectAllFiles(){
        selectAllCheckbox.click();
    }

    public boolean areAllFilesSelected(){
        boolean flag = false;
        for (WebElement eachFile : allFilesCheckBoxes) {
            if (eachFile.isSelected()) flag = true;
            else flag = false;
        }
        return flag;
    }

}
