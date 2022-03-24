package com.bridgelabz.facebook.page;

import com.bridgelabz.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Altamash Bagwan')]")
    WebElement userProfile;

    @FindBy(xpath = "//span[contains(text(), 'Friends')]")
    WebElement findFriend;

    @FindBy(xpath = "//span[contains(text(),'Groups')]")
    WebElement groups;

    @FindBy(xpath = "//span[contains(text(),'Marketplace')]")
    WebElement marketplace;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePagePageTitle() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public ProfilePage clickOnProfile() {
        userProfile.click();
        return new ProfilePage();
    }

    public FindFriendsPage clickOnFriends() {
        findFriend.click();
        return new FindFriendsPage();
    }

    public GroupsPage clickOnGroups() {
        groups.click();
        return new GroupsPage();
    }

    public MarketplacePage clickOnMarketplace() {
        marketplace.click();
        return new MarketplacePage();
    }

}
