package com.bridgelabz.facebook;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelabz.facebook.page.Homepage;
import com.bridgelabz.facebook.page.LoginPage;
import com.bridgelabz.facebook.page.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    Homepage homepage;
    ProfilePage profilePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUo() {
        initialiazation();
        loginPage = new LoginPage();
        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

//    @Test
//    public void verifyHomePageTitleTest() {
//       String homePageTitle = homepage.verifyHomePagePageTitle();
//        Assert.assertEquals(homePageTitle,"Kai Gazi | Facebook", homePageTitle);
//    }

    @Test
    public void verifyClickOnProfile() {
        profilePage = homepage.clickOnProfile();

    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
