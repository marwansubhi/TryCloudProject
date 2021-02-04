package com.trycloud.tests.Vida.ContactPage;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ContactsModule {

    @Test
    public void contact() {
        Driver.getDriver().get(ConfigurationReader.getProperty("tryCloudUrl"));
        BrowserUtils.sleep(3);
        Driver.getDriver().get(ConfigurationReader.getProperty("tryCloudUrl"));
        BrowserUtils.sleep(3);
        WebElement userNameInput = Driver.getDriver().findElement(By.xpath("//p[@class='grouptop']//input"));
        String username =  ConfigurationReader.getProperty("username");
        userNameInput.sendKeys(username+ Keys.ENTER);

        WebElement passWordInput = Driver.getDriver().findElement(By.xpath("//p[@class='groupbottom']//input"));
        String password =  ConfigurationReader.getProperty("password");
        passWordInput.sendKeys(password+ Keys.ENTER);

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@class='login primary']"));
        loginButton.click();

        BrowserUtils.sleep(3);

        WebElement contactButton = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//li[6]"));
        contactButton.click();

        //BrowserUtils.sleep(2);

        Driver.closeDriver();

    }
}
