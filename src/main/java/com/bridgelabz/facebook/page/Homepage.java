package com.bridgelabz.facebook.page;

import com.bridgelabz.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Kai Gazi')]")
    WebElement userProfile;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePagePageTitle() {
        return driver.getTitle();
    }

    public ProfilePage clickOnProfile() {
        userProfile.click();
        return new ProfilePage();
    }

}
