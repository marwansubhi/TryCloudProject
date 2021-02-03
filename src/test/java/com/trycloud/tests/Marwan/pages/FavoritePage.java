package com.trycloud.tests.Marwan.pages;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritePage extends TestBase {
    @FindBy(xpath = "(//a[@href='/index.php/apps/files?dir=/&openfile=9145'])[2]")
    WebElement favoriteFile;

    public FavoritePage(){
        PageFactory.initElements(driver,this);

    }
    public boolean isLocated(){
        if (favoriteFile.isDisplayed())return true;
        else return false;
    }
}
//*[@id="fileList"]/tr/td[1]/a/span[1]
//*[@id="fileList"]/tr/td[1]/a/span[1]
//*[@id="fileList"]/tr/td[1]/a/span[1]
//*[@id="fileList"]/tr[2]/td[1]/a/span[1]