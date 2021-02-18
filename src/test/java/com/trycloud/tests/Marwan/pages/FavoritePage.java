package com.trycloud.tests.Marwan.pages;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FavoritePage extends TestBase {
    @FindBy(xpath = "//*[@id='fileList']/tr/td[1]/a/span/span[.='csharp']")
    WebElement favoriteFile;

    @FindBy(xpath = "//*[@id='fileList']/tr/td[1]/a/span[3]/a[2]")
    WebElement actionTab;

    @FindBy(xpath = "//*[@id='fileList']/tr/td[1]/div/ul/li[3]/a/span[.='Remove from favorites']")
    WebElement removeMyFile;
    @FindBy(how = How.XPATH, using = "//*[@class='filename']/a/span/span")
    List<WebElement> allFavoriteFolders;

    @FindBy(how = How.XPATH, using = "//*[@class='filename']/a/span/span[.='Java Package']")
    WebElement myFile;


    public WebElement getMyFile(){
        return myFile;
    }

    public FavoritePage(){
        PageFactory.initElements(driver,this);

    }
    public boolean isLocated(){
        if (favoriteFile.isDisplayed())return true;
        else return false;
    }

    public void clickAction(){
        actionTab.click();
    }

    public void removeFile(){

       removeMyFile.click();
    }

    public List<WebElement> getAllFavoriteFolders(){
        return allFavoriteFolders;
    }

    public ArrayList<String> allFavoriteFolderTexts(){
        ArrayList<String> list = new ArrayList<>();
        for (WebElement eachFolderElement : getAllFavoriteFolders()) {
            list.add(eachFolderElement.getText());
        }
        return list;
    }

    public boolean isFileRemoved(){
        boolean flag = false;
       if (allFavoriteFolderTexts().contains(getMyFile().getText())){
           flag = true;
       }
       return flag;
    }


}





//*[@id="fileList"]/tr/td[1]/a/span[1]
//*[@id="fileList"]/tr/td[1]/a/span[1]
//*[@id="fileList"]/tr/td[1]/a/span[1]
//*[@id="fileList"]/tr[2]/td[1]/a/span[1]
//*[@id="fileList"]/tr/td[1]/a/span[1]/span[1]

//*[@id="fileList"]/tr/td[1]  ----> table

//*[@id='fileList']/tr/td[1]/a/span/span[.='HelloWorld']

//*[@id="fileList"]/tr/td[1]/a/span[2]/a[2]/span[1]

//*[@id="fileList"]/tr/td[1]/a/span[2]/a[2]
//*[@id="fileList"]/tr/td[1]/a/span[2]/a[2]/span[1]