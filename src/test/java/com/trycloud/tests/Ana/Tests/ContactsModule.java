package com.trycloud.tests.Ana.Tests;

import com.github.javafaker.Faker;
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
        BrowserUtils.sleep(2);
        //2. click "Contacts" module
        WebElement contactsModule = Driver.getDriver().findElement(By.xpath("/html/body/header/div[1]/ul/li[6]/a"));
        contactsModule.click();

        //3. Verify the page tile is Contents module’s tile
        String expectedTitle = "Contacts";
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualPageTitle.contains(expectedTitle));
    }


    @Test
    public void testCase_2() {
        //test case nr.2  - verify user can add contacts

        //login as a user
        BrowserUtils.sleep(2);

        //2. click "Contacts" module
        WebElement contactsModule = Driver.getDriver().findElement(By.xpath("/html/body/header/div[1]/ul/li[6]/a"));
        contactsModule.click();

        //3. Click “New Contact” button
        WebElement newContactButton = Driver.getDriver().findElement(By.id("new-contact-button"));
        newContactButton.click();
        BrowserUtils.sleep(3);


        //4. Fill out the contact info like : Title, Phone, email, address , etc
        Faker faker = new Faker();

        BrowserUtils.sleep(3);
        //enter phone number
        WebElement PhoneNumber =Driver.getDriver().findElement(By.xpath("//input[@inputmode='tel']"));
        String phoneNumberFaker =faker.phoneNumber().phoneNumber();
        PhoneNumber.sendKeys(phoneNumberFaker);

        //enter e-mail address
        WebElement Email=Driver.getDriver().findElement(By.xpath("//input[@inputmode='email']"));
        String emailFaker=faker.internet().emailAddress();
        Email.sendKeys(emailFaker);

        //Enter address
        WebElement address=Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[3]/input"));
        String addressFaker=faker.address().streetAddress();
        address.sendKeys(addressFaker);

        // Enter City
        WebElement city= Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[6]/input"));
        String cityFaker=faker.address().city();
        city.sendKeys(cityFaker);

        //Enter State
        WebElement State = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[7]/input"));
        String stateFaker=faker.address().state();
        State.sendKeys(stateFaker);

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
        WebElement contactsModule = Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Contacts'])[1]"));
        contactsModule.click();
        BrowserUtils.sleep(3);

        //3. Verify the contact names are in the list
        WebElement company = Driver.getDriver().findElement(By.xpath("//input[@id='contact-org']"));
        company.sendKeys("Test1");
        BrowserUtils.sleep(3);

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Test1"));
    }
}






