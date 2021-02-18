package com.trycloud.tests.Miray.test;

import com.github.javafaker.Faker;
import com.trycloud.tests.Miray.pages.ContactModulePage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModuleTest extends TestBase {

    @Test
    public void accessToContactModule(){
        HomeTestPage homeTestPage = new HomeTestPage();
        homeTestPage.setHomePage();
        ContactModulePage contactModulePage = new ContactModulePage(driver);
        contactModulePage.newContactButton().click();



        Faker faker = new Faker();

        contactModulePage.nameField().clear();
        BrowserUtils.sleep(2);
        contactModulePage.nameField().sendKeys(faker.name().fullName());
        BrowserUtils.sleep(2);
        contactModulePage.companyField().sendKeys(faker.company().name());
        BrowserUtils.sleep(2);
        contactModulePage.titleField().sendKeys("SDET");
        BrowserUtils.sleep(2);
        contactModulePage.phoneField().sendKeys(faker.phoneNumber().phoneNumber());
        BrowserUtils.sleep(2);
        contactModulePage.emailField().sendKeys(faker.internet().emailAddress());
        BrowserUtils.sleep(2);
        contactModulePage.addressField().sendKeys(faker.address().fullAddress());
        BrowserUtils.sleep(2);
        contactModulePage.cityField().sendKeys(faker.address().city());
        BrowserUtils.sleep(2);
        contactModulePage.countryField().sendKeys(faker.address().country());
        BrowserUtils.sleep(2);
        contactModulePage.postalCodeField().sendKeys(faker.address().zipCode());
        BrowserUtils.sleep(2);
        contactModulePage.postOfficeBoxField().sendKeys(faker.address().cityPrefix());
        BrowserUtils.sleep(2);
        contactModulePage.stateOrProvinceField().sendKeys(faker.address().state());
        BrowserUtils.sleep(2);











    }
}
