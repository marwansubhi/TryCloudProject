package com.trycloud.tests.Agalar;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Us3FileModule {

    @Test
    public void TryCloudSighIn() {
        Driver.getDriver().get("https://app.trycloud.net/index.php/login");



      TryCloudSighIn1 tryCloudSighIn1 = new TryCloudSighIn1();

      tryCloudSighIn1.inputLogIn.sendKeys(ConfigurationReader.getProperty("username"));
      tryCloudSighIn1.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
      tryCloudSighIn1.logInButton.click();


    }
}