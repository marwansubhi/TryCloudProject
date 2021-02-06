package com.trycloud.tests.Kate;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class CircleModuleTest {

    @BeforeMethod
    public void LogIn() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        for (int i = 1; i <= 4; ) {//doesn't work properly
            Driver.getDriver().findElement(By.id("user")).sendKeys(ConfigurationReader.getProperty("username" + i++));
            break;
        }
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.id("submit-form")).click();
        BrowserUtils.sleep(2);
    }

    @Test
    public void AccessCircleModuleTest() {
        Actions actions = new Actions(Driver.getDriver());
        WebElement circleModule = Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Circles'])[1]"));
        //check if the "Circle" text appears by hover overing
        actions.moveToElement(circleModule).perform();
        WebElement moduleName = Driver.getDriver().findElement(By.xpath("//span[.='Circles']"));
        Assert.assertTrue(moduleName.isDisplayed()); //FAILED! Why Circles is not displayed? I located it as a text
    }

    @Test
    public void CreatingSecretCircleTest() {
        //1. go to the Circle module
        Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Circles'])[1]")).click();
        BrowserUtils.sleep(1);
        //2. in the "Create a new circle" box type the random name of a Circle
        Faker faker = new Faker();
        String expectedCircleName = faker.random().hex();
        List<String> names = new LinkedList<>();//Can we add here all names faker creates?
        Driver.getDriver().findElement(By.id("circles_new_name")).sendKeys(expectedCircleName);
        BrowserUtils.sleep(1);
        //3. Select a Secret type of Circle from the "Select a circle type"
        Driver.getDriver().findElement(By.id("circles_new_type")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//option[.='Create a secret circle']")).click();
        BrowserUtils.sleep(1);
        //4. Push the "Creation" button
        Driver.getDriver().findElement(By.id("circles_new_submit")).click();
        BrowserUtils.sleep(1);
        //5. Verify that the Circle was created
        String actualCircleName = Driver.getDriver().findElement(By.xpath("//div[@id='name']")).getText();

        Assert.assertEquals(expectedCircleName, actualCircleName, "Circle with such a name was not created");
    }

    @Test
    public void CreatingPersonalCircleTest() {
        //1. go to the Circle module
        Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Circles'])[1]")).click();
        BrowserUtils.sleep(1);
        //2. in the "Create a new circle" box type the random name of a Circle
        Faker faker = new Faker();
        String expectedCircleName = faker.random().hex();
        Driver.getDriver().findElement(By.id("circles_new_name")).sendKeys(expectedCircleName);
        BrowserUtils.sleep(1);
        //3. Select a Personal type of Circle from the "Select a circle type"
        Driver.getDriver().findElement(By.id("circles_new_type")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//option[.='Create a personal circle']")).click();
        BrowserUtils.sleep(1);
        //4. Push the "Creation" button
        Driver.getDriver().findElement(By.id("circles_new_submit")).click();
        BrowserUtils.sleep(1);
        //5. Verify that the Circle was created
        String actualCircleName = Driver.getDriver().findElement(By.xpath("//div[@id='name']")).getText();

        Assert.assertEquals(expectedCircleName, actualCircleName, "Circle with such a name was not created");
    }

    @Test
    public void AccessToAllCirclesTest() {
        //1. go to the Circle module
        Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Circles'])[1]")).click();
        BrowserUtils.sleep(1);
        //2.scroll down and chose "All Circles"
        //JavascriptExecutor scrollDown = (JavascriptExecutor) Driver.getDriver();



        //div[.='All circles']
    }

}
