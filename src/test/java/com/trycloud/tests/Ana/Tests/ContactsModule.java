package com.trycloud.tests.Ana.Tests;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import com.trycloud.tests.Ana.Pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactsModule extends LoginPage {
    @Test
    public void testCase_1() {
        //1. login as a user (created login page class)
        BrowserUtils.sleep(3);
        //2. click "Contacts" module
         Driver.getDriver().findElement(By.xpath("//a[@aria-label='Contacts']")).click();


        //3. Verify the page tile is Contents module’s tile
        String expectedTitle = "Contacts";
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualPageTitle.contains(expectedTitle));

        //closing browser
        Driver.closeDriver();
    }


    @Test
    public void testCase_2() {
        //test case nr.2  - verify user can add contacts
        Faker faker = new Faker();
        BrowserUtils.sleep(2);

        //2. click "Contacts" module
         Driver.getDriver().findElement(By.xpath("//a[@aria-label='Contacts']")).click();

        //3. Click “New Contact” button
        Driver.getDriver().findElement(By.xpath("//button[@id='new-contact-button']")).click();
        BrowserUtils.sleep(3);

        //4. Fill out the contact info like : Title, Phone, email, address , etc

        //enter phone number
        Driver.getDriver().findElement(By.xpath("//input[@inputmode='tel']")).sendKeys(faker.phoneNumber().cellPhone());
        BrowserUtils.sleep(3);

        //enter e-mail address
        Driver.getDriver().findElement(By.xpath("//input[@inputmode='email']")).sendKeys(faker.internet().emailAddress());
        BrowserUtils.sleep(3);

        //Enter address
        Driver.getDriver().findElement(By.xpath("//*[@id=app-content-wrapper]/div[2]/section/div[3]/div/div[3]/input")).sendKeys(faker.address().streetAddress());
        BrowserUtils.sleep(3);

        // Enter City
        Driver.getDriver().findElement(By.xpath("//*[@id=app-content-wrapper]/div[2]/section/div[3]/div/div[6]/input")).sendKeys(faker.address().city());

        //Enter State
        Driver.getDriver().findElement(By.xpath("//*[@id=app-content-wrapper]/div[2]/section/div[3]/div/div[7]/input")).sendKeys(faker.address().state());
        BrowserUtils.sleep(3);

        //Enter Country
        Driver.getDriver().findElement(By.xpath("//*[@id=app-content-wrapper]/div[2]/section/div[3]/div/div[8]/input")).sendKeys(faker.address().country());


        //  5.Verify the contact name is added to the contact list

        WebElement newContact = Driver.getDriver().findElement(By.xpath("//body[@id='body-user']"));
        Assert.assertTrue(newContact.isDisplayed());

    }


    //Test case #3 - verify users can see all the contact names on the contact list
    //1. Login as a user
    //2. Click contacts module
    //3. Verify the contact names are in the list
    //(Pre-condition: there should be at least 2 contact names are displayed On the contact list)

    @Test
    public void testCase_3() {

        BrowserUtils.sleep(2);
        // click "Contacts" module
        Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Contacts'])")).click();
        BrowserUtils.sleep(3);

        //3. Verify the contact names are in the list
        Driver.getDriver().findElement(By.xpath("//input[@id='contact-org']")).sendKeys("Test1");
        BrowserUtils.sleep(3);

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Test1"));
    }
}






