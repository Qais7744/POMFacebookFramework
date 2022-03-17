package com.bridgelabz.facebook;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelabz.facebook.page.Homepage;
import com.bridgelabz.facebook.page.LoginPage;
import com.bridgelabz.facebook.util.TestUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    Homepage homepage;
    String sheetName = "Login";
    Logger log;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        log = Logger.getLogger(LoginPageTest.class);
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 2)
    public void loginPageTitleTest() {
        log.info("+++++++++++++++++++++++++++++++++++++ Starting test case ++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("+++++++++++++++++++++++++++++++++++++ loginPageTitleTest ++++++++++++++++++++++++++++++++++++++++++++++");
        String title = loginPage.validataLoginPageTitle();
        log.info("Login Page title is---->" + title);
        Assert.assertEquals(title, "Facebook – log in or sign up", title);

        log.info("+++++++++++++++++++++++++++++++++++++ Ending test case ++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("+++++++++++++++++++++++++++++++++++++ loginPageTitleTest ++++++++++++++++++++++++++++++++++++++++++++++");
    }

//    @Test(priority = 2)
//    public void loginTest() {
//        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//    }

    @DataProvider
    public Object[][] getLoginTestdata() {
        return TestUtil.getTestData(sheetName);
    }

    @Test(priority = 1, dataProvider = "getLoginTestdata")
    public void loginTest(String username, String password) {
        log.info("+++++++++++++++++++++++++++++++++++++ Starting test case ++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("+++++++++++++++++++++++++++++++++++++ getLoginTestdata ++++++++++++++++++++++++++++++++++++++++++++++");
        loginPage = new LoginPage();
        homepage = loginPage.login(username, password);

        log.info("+++++++++++++++++++++++++++++++++++++ Ending test case ++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("+++++++++++++++++++++++++++++++++++++ getLoginTestdata ++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        log.info("+++++++++++++++++++++++++++++++++++++ Browser is closed ++++++++++++++++++++++++++++++++++++++++++++++");
    }

}
