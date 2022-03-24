package com.bridgelabz.facebook.page;

import com.bridgelabz.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketplacePage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Notifications')]")
    WebElement notification;

    @FindBy(xpath = "//span[contains(text(),'Inbox')]")
    WebElement inbox;

    @FindBy(xpath = "//span[contains(text(),'Buying')]")
    WebElement buying;

    @FindBy(xpath = "//span[contains(text(),'Selling')]")
    WebElement selling;

    public MarketplacePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyMarketplacePageTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public NotificationPage clickOnNotifaction() {
        notification.click();
        return new NotificationPage();
    }

    public InboxPage clickOnInbox() {
        inbox.click();
        return new InboxPage();
    }

    public BuyingPage clickOnBuying() {
        buying.click();
        return new BuyingPage();
    }

    public SellingPage clickOnSelling() {
        selling.click();
        return new SellingPage();
    }
}
