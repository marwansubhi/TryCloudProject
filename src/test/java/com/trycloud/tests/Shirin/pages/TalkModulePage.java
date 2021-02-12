package com.trycloud.tests.Shirin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TalkModulePage {
    WebDriver driver;
    public TalkModulePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getSearchBox(){
        return driver.findElement(By.xpath("//*[@class='app-navigation-search__input']"));
    }
    public void getUser(String name){
        getSearchBox().sendKeys(name);
        WebElement user = driver.findElement(By.xpath("//*[@aria-label='Conversation, "+name+"']"));
        user.click();
    }
    public WebElement getMessageBox(){
        return driver.findElement(By.xpath("//*[@class='new-message-form__advancedinput']"));
    }
    public void writeMessage(String message){
        getMessageBox().sendKeys(message);
    }
    public WebElement getSubmitButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    public String getLastMessage(){
        return driver.findElement(By.xpath("(//*[@class='rich-text--wrapper'])[last()]")).getText();
    }

}
