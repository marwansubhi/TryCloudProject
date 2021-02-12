package com.trycloud.tests.Kate.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.Kate.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CircleModuleTest {

    @BeforeClass
    public void LogIn() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for (int i = 1; i <= 4; ) {
            loginPage.userInputBox.sendKeys(ConfigurationReader.getProperty("username1" + i));//add a loop for usernames
            ++i;
            break;
        }

        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.submitButton.click();
    }

    @Test
    public void AccessCircleModuleTest() {
        Actions actions = new Actions(Driver.getDriver());
        WebElement circleModule = Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Circles'])[1]"));
        //check if the "Circle" text appears by hover overing
        actions.moveToElement(circleModule).perform();
        String moduleName = Driver.getDriver().findElement(By.xpath("(//*[contains(text(),'Circles')])[1]")).getText();
        String expectedModuleName = "Circle";
        Assert.assertTrue(moduleName.contains(expectedModuleName));
    }

    @Test
    public void CreatingSecretCircleTest() {
        //1. go to the Circle module
        Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Circles'])[1]")).click();
        BrowserUtils.sleep(1);
        //2. in the "Create a new circle" box type the random name of a Circle
        Faker faker = new Faker();
        String expectedCircleName = faker.random().hex();
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
        //2.click on "Personal Circles"
        Driver.getDriver().findElement(By.xpath("//*[.='Personal circles']")).click();
        //3. From Personal Circles click on "All Circles"
        Driver.getDriver().findElement(By.xpath("//*[.='All circles']")).click();
        List<WebElement> allCircles = Driver.getDriver().findElements(By.xpath("//div[@class='circle']"));
        //is not finished
        Assert.assertFalse(allCircles.isEmpty());


    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().findElement(By.id("expand")).click();
        Driver.getDriver().findElement(By.xpath("//li[@data-id='logout']")).click();
        BrowserUtils.sleep(5);

        Driver.getDriver().quit();
    }
}
