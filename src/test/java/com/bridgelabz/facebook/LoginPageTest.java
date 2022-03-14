package com.bridgelabz.facebook;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelabz.facebook.page.Homepage;
import com.bridgelabz.facebook.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    Homepage homepage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUo() {
        initialiazation();
        loginPage = new LoginPage();
    }


    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validataLoginPageTitle();
        Assert.assertEquals(title, "Facebook – log in or sign up",title);
    }

//    @Test(priority = 2)
//    public void fbLogoImageTest() {
//        boolean logo = loginPage.validateFbImage();
//        Assert.assertTrue(logo);
//    }

    @Test(priority = 2)
    public void loginTest() {
        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
