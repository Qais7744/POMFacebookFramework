package com.bridgelabz.facebook;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelabz.facebook.page.FindFriendsPage;
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
    FindFriendsPage findFriendsPage;

    public HomePageTest() {
        super();
    }

    //Test cases should be separated -- Independent each other.
    //Before each test case -- launch the browser.
    //@Test -- execute test case.
    // After each test case -- close the browser.
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homepage.verifyHomePagePageTitle();
        Assert.assertEquals(homePageTitle, "(2) Facebook", "HomePage is not matched");
    }

    @Test(priority = 2)
    public void verifyClickOnProfile() {
        profilePage = homepage.clickOnProfile();

    }

    @Test(priority = 3)
    public void verifyClickOnFriends() {
        findFriendsPage = homepage.clickOnFriends();

    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
