package com.bridgelabz.facebook;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelabz.facebook.page.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MarketplacePageTest extends TestBase {

    LoginPage loginPage;
    Homepage homepage;
    MarketplacePage marketplacePage;
    NotificationPage notificationPage;
    InboxPage inboxPage;
    BuyingPage buyingPage;
    SellingPage sellingPage;

    public MarketplacePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homepage = new Homepage();
        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        marketplacePage = homepage.clickOnMarketplace();
    }

    @Test(priority = 1)
    public void verifyMarketplacePageTitleTest() {
        String marketplacePageTitle = marketplacePage.verifyMarketplacePageTitle();
        Assert.assertEquals(marketplacePageTitle, "(2) Facebook Marketplace | Facebook", "MarketplacePage is not matched");
    }

    @Test(priority = 2)
    public void verifyClickOnNotification() {
        notificationPage = marketplacePage.clickOnNotifaction();

    }

    @Test(priority = 3)
    public void verifyClickOnInbox() {
        inboxPage = marketplacePage.clickOnInbox();

    }

    @Test(priority = 4)
    public void verifyClickOnBuying() {
        buyingPage = marketplacePage.clickOnBuying();

    }

    @Test(priority = 5)
    public void verifyClickOnSelling() {
        sellingPage = marketplacePage.clickOnSelling();

    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}

