package com.trycloud.tests.Ella;

import org.testng.annotations.Test;

public class US_3_User_Able_Access_Files {
    String loginBox = "//input[@placeholder='Username or email']";
    String passwordBox = "//input[@placeholder='Password']";
    String loginButton = "//input[@value='Log in']";

    /*
    1.Login as a user
    2.Click the “+” icon on top
    3.Click “upload file”
     4.Upload a file
     5.Verify the file is displayed on the page
     */



    @Test(description = "verify users can upload a file directly to the homepage (File-Uploading)")
    public void TC_5() {


    }

}
