package com.trycloud.tests.alex.pages;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;

public class HomePage extends TestBase {



    String filesModuleXpath="//*[@id=\"appmenu\"]/li[2]/a";
    String photosModuleXpath="//*[@id=\"appmenu\"]/li[3]/a";
    String activityModuleXpath="//*[@id=\"appmenu\"]/li[4]/a";
    String talkModuleXpath="//*[@id=\"appmenu\"]/li[5]/a";
    String contactsModuleXpath ="//*[@id=\"appmenu\"]/li[6]/a";
    String deckModuleXpath="//*[@id=\"appmenu\"]/li[9]/a";
    String calendarModuleXpath="//*[@id=\"appmenu\"]/li[8]/a";




    public void clickFileModule(){    driver.findElement(By.xpath(filesModuleXpath)).click();}
    public void clickPhotosModule(){ driver.findElement(By.xpath(photosModuleXpath)).click();}

    public void clickActivityModule(){
        driver.findElement(By.xpath(activityModuleXpath)).click();
    }

    public void clickTalkModule(){
        driver.findElement(By.xpath(talkModuleXpath)).click();
    }
    public void clickContactsModule(){
        driver.findElement(By.xpath(contactsModuleXpath));
    }
    public void clickCalendarModule(){
        driver.findElement(By.xpath(calendarModuleXpath));
    }

    public void clickDeckModule(){
        driver.findElement(By.xpath(deckModuleXpath));
    }

}







