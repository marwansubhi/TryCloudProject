package com.trycloud.tests.Miray.test;

import com.github.javafaker.Faker;
import com.trycloud.tests.Miray.pages.ContactModulePage;
import com.trycloud.tests.base.TestBase;
import org.apache.tools.ant.taskdefs.Java;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModuleTest extends TestBase {

    @Test
    public void accessToContactModule(){
        LoginPageTest loginPageTest = new LoginPageTest();
        loginPageTest.LoginTest();
        HomeTestPage homeTestPage =new HomeTestPage();
        homeTestPage.setHomePage();
        ContactModulePage contactModulePage =new ContactModulePage(driver);



        Faker faker = new Faker();

        contactModulePage.nameField().sendKeys(faker.name().fullName());
        contactModulePage.companyField().sendKeys(faker.company().name());
        contactModulePage.titleField().sendKeys(faker.resolve("Sdet"));
        contactModulePage.phoneField().sendKeys(faker.phoneNumber().phoneNumber());
        contactModulePage.emailField().sendKeys(faker.internet().emailAddress());
        contactModulePage.addressField().sendKeys(faker.address().fullAddress());
        contactModulePage.cityField().sendKeys(faker.address().city());
        contactModulePage.countryField().sendKeys(faker.address().country());
        contactModulePage.postalCodeField().sendKeys(faker.address().zipCode());
        contactModulePage.postOfficeBoxField().sendKeys(faker.address().cityPrefix());
        contactModulePage.stateOrProvinceField().sendKeys(faker.address().state());









    }
}
