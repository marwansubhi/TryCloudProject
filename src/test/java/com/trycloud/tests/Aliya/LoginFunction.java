package com.trycloud.tests.Aliya;


import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LoginFunction {
    @Test
    public void Login() throws InterruptedException{
        Driver.getDriver().get("http://app.trycloud.net/index.php/apps/files/?dir=/&fileid=6264");
//with this list and for loop with one click it will check all 4 usernames one by one
        ArrayList<String> UserNames = new ArrayList<String>(Arrays.asList(
                ("User11"),
                ("User41"),
                ("User71"),
                ("User101")));
        String Password = "Userpass123";

        for(String each: UserNames){
            WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='user']"));
            userName.sendKeys(each);
            Thread.sleep(1);
            WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
            password.sendKeys(Password);
            Thread.sleep(1);
            WebElement login = Driver.getDriver().findElement(By.xpath("//input[@id='submit']"));
            login.click();
            Thread.sleep(1);
            WebElement roundSetting = Driver.getDriver().findElement(By.xpath("//img[@width='32']"));
            roundSetting.click();
            Thread.sleep(1);
            WebElement logOut = Driver.getDriver().findElement(By.xpath("(//li[@data-id])[17]"));
            logOut.click();



        }


    }
}


