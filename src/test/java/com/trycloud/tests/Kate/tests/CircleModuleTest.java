package com.trycloud.tests.Kate.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.Kate.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CircleModuleTest {

    @BeforeClass
    public void LogIn() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.userInputBox.sendKeys(ConfigurationReader.getProperty("username1"));//add a loop for usernames
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
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. in the "Create a new circle" box type the random name of a Circle
        Faker faker = new Faker();
        String expectedCircleName = faker.random().hex();
        Driver.getDriver().findElement(By.id("circles_new_name")).sendKeys(expectedCircleName);
        //3. Select a Secret type of Circle from the "Select a circle type"
        Driver.getDriver().findElement(By.id("circles_new_type")).click();
        Driver.getDriver().findElement(By.xpath("//option[.='Create a secret circle']")).click();
        //4. Push the "Creation" button
        Driver.getDriver().findElement(By.id("circles_new_submit")).click();
        //5. Verify that the Circle was created
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(Driver.getDriver().findElement(By.xpath("//div[@id='name']")), expectedCircleName));
        String actualCircleName = Driver.getDriver().findElement(By.xpath("//div[@id='name']")).getText();

        Assert.assertEquals(expectedCircleName, actualCircleName, "Circle with such a name was not created");
    }

    @Test
    public void CreatingPersonalCircleTest() {
        //1. go to the Circle module
        Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Circles'])[1]")).click();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. in the "Create a new circle" box type the random name of a Circle
        Faker faker = new Faker();
        String expectedCircleName = faker.random().hex();
        Driver.getDriver().findElement(By.id("circles_new_name")).sendKeys(expectedCircleName);
        //3. Select a Personal type of Circle from the "Select a circle type"
        Driver.getDriver().findElement(By.id("circles_new_type")).click();
        Driver.getDriver().findElement(By.xpath("//option[.='Create a personal circle']")).click();
        //4. Push the "Creation" button
        Driver.getDriver().findElement(By.id("circles_new_submit")).click();
        //5. Verify that the Circle was created
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(Driver.getDriver().findElement(By.xpath("//div[@id='name']")), expectedCircleName));
        String actualCircleName = Driver.getDriver().findElement(By.xpath("//div[@id='name']")).getText();

        Assert.assertEquals(expectedCircleName, actualCircleName, "Circle with such a name was not created");
    }

    @Test
    public void AccessToAllCirclesTest() {
        //1. go to the Circle module
        Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Circles'])[1]")).click();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Create a new Personal circle
        Faker faker = new Faker();
        String expectedCircleName1 = faker.random().hex();
        Driver.getDriver().findElement(By.id("circles_new_name")).sendKeys(expectedCircleName1);
        //3. Select a Personal type of Circle from the "Select a circle type"
        Driver.getDriver().findElement(By.id("circles_new_type")).click();
        Driver.getDriver().findElement(By.xpath("//option[.='Create a personal circle']")).click();
        //4. Push the "Creation" button
        Driver.getDriver().findElement(By.id("circles_new_submit")).click();
        //5. Create a new Secret circle
        String expectedCircleName2 = faker.random().hex();
        Driver.getDriver().findElement(By.id("circles_new_name")).sendKeys(expectedCircleName2);
        //6. Select a Secret type of Circle from the "Select a circle type"
        Driver.getDriver().findElement(By.id("circles_new_type")).click();
        Driver.getDriver().findElement(By.xpath("//option[.='Create a secret circle']")).click();
        //7. Push the "Creation" button
        Driver.getDriver().findElement(By.id("circles_new_submit")).click();
        Driver.getDriver().findElement(By.xpath("//div[.='All circles']")).click();
        //didn't finish
    }

    @AfterClass
    public void tearDown() {
        Driver.getDriver().close();
    }
}
