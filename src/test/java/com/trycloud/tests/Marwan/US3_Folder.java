package com.trycloud.tests.Marwan;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US3_Folder extends TestBase {
    @Test
    public void test_folder_creation() {
        WebElement userNameBox = driver.findElement(By.xpath("//*[@id='user']"));
        WebElement passwordBox = driver.findElement(By.xpath("//*[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='submit-form']"));
        userNameBox.sendKeys("User11");
        BrowserUtils.sleep(2);
        passwordBox.sendKeys("Userpass123");
        BrowserUtils.sleep(2);
        loginButton.click();
        BrowserUtils.sleep(5);
        WebElement fileModule = driver.findElement(By.xpath("(//*[@href='/index.php/apps/files/'])[1]"));
        fileModule.click();
        WebElement plusSign = driver.findElement(By.xpath("//*[@class='button new']"));
        plusSign.click();
        BrowserUtils.sleep(2);
        WebElement newFolder = driver.findElement(By.xpath("//span[.='New folder']"));
        newFolder.click();
        BrowserUtils.sleep(2);
        WebElement fileName = driver.findElement(By.xpath("//*[@id='view13-input-folder']"));
        fileName.sendKeys("Java Package");
        BrowserUtils.sleep(2);
        WebElement submitButton = driver.findElement(By.xpath("(//*[@type='submit'])[2]"));
        submitButton.click();

        List<WebElement> folderList = driver.findElements(By.xpath("//*[@id='fileList']/tr/td[2]/a/span/span"));
        String expectedFolderName = "Test Folder";

        for (WebElement each : folderList) {

            if (each.getText().equals(expectedFolderName)){
                Assert.assertEquals(each.getText(),expectedFolderName);
            }

        }

    }
}
