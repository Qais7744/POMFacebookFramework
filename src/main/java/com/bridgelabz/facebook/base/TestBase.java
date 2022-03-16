package com.bridgelabz.facebook.base;

import com.bridgelabz.facebook.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static Logger log = Logger.getLogger(TestBase.class);

    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream ip
                    = new FileInputStream("C:\\Users\\Altamash\\" +
                    "IdeaProjects\\OpenPageModelFramwork\\" +
                    "src\\main\\java\\com\\bridgelabz\\facebook" +
                    "\\config\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        log.info("+++++++++++++++++++++++++++++++++++++ Starting test cases execution ++++++++++++++++++++++++++++++++++++++++++++++");
        String browserName = prop.getProperty("browser");
        browserName.equals("chrome");
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        log.info("launching chrome browser");

        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        log.info("entering application URL");
        log.warn("Hey this is just a warning message");
        log.fatal("Hey this is just fatal error message");
        log.debug("this is debug message");
    }

}
