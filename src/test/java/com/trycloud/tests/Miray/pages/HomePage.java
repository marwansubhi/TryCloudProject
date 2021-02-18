package com.trycloud.tests.Miray.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement contactModuleButton(){
        return driver.findElement(By.xpath("//ul[@id='appmenu']/li[6]"));

    }
}
