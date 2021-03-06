package com.bridgelabz.facebook;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelabz.facebook.page.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    Homepage homepage;
    ProfilePage profilePage;
    FindFriendsPage findFriendsPage;
    GroupsPage groupsPage;
    MarketplacePage marketplace;

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

    @Test(priority = 4)
    public void verifyClickOnGroups() {
        groupsPage = homepage.clickOnGroups();

    }

    @Test(priority = 5)
    public void verifyClickOnMarketplace() {
        marketplace = homepage.clickOnMarketplace();

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
