package com.trycloud.tests.Miray.pages;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactModulePage {
    WebDriver driver;

    public ContactModulePage(WebDriver driver){
        this.driver=driver;
    }

   public WebElement newContactButton (){
       return driver.findElement(By.xpath("//button[@id='new-contact-button']"));
   }
   public WebElement nameField(){
        return driver.findElement(By.xpath("//input[@id='contact-fullname']"));
   }
   public WebElement companyField(){
        return driver.findElement(By.xpath("//input[@id='contact-org']"));
   }
   public WebElement titleField(){
        return driver.findElement(By.xpath("//input[@id='contact-title']"));
   }
   public WebElement phoneField(){
        return driver.findElement(By.xpath("//input[@inputmode='tel']"));
   }
   public WebElement emailField(){
        return driver.findElement(By.xpath("//input[@inputmode='email']"));
   }
   public WebElement postOfficeBoxField(){
        return driver.findElement(By.xpath("(//input[@class='property__value'])[3]"));
   }
   public WebElement addressField(){
        return driver.findElement(By.xpath("(//input[@class='property__value'])[4]"));
   }
    public WebElement postalCodeField(){
        return driver.findElement(By.xpath("(//input[@class='property__value'])[6]"));
    }
    public WebElement cityField(){
        return driver.findElement(By.xpath("(//input[@class='property__value'])[7]"));
    }
    public WebElement stateOrProvinceField(){
        return driver.findElement(By.xpath("(//input[@class='property__value'])[8]"));
    }
    public WebElement countryField(){
        return driver.findElement(By.xpath("(//input[@class='property__value'])[9]"));
    }




}
