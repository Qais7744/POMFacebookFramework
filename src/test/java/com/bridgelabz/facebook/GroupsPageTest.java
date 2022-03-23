package com.bridgelabz.facebook;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelabz.facebook.page.DiscoverPage;
import com.bridgelabz.facebook.page.GroupsPage;
import com.bridgelabz.facebook.page.Homepage;
import com.bridgelabz.facebook.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupsPageTest extends TestBase {

    LoginPage loginPage;
    Homepage homepage;
    GroupsPage groupsPage;
    DiscoverPage discoverPage;

    public GroupsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homepage = new Homepage();
        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        groupsPage = homepage.clickOnGroups();
        discoverPage = groupsPage.clickOnDiscover();
    }

    @Test(priority = 1)
    public void verifyDiscoverPageTitleTest() {
        String groupsPageTitle = groupsPage.verifyGroupsPageTitle();
        Assert.assertEquals(groupsPageTitle, "Groups | Facebook", "GroupsPage is not matched");
    }

    @Test(priority = 2)
    public void verifyClickOnWorkAndEduaction() {
        discoverPage = groupsPage.clickOnDiscover();

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
