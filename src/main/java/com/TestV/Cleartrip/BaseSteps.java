package com.TestV.Cleartrip;
import com.TestV.Cleartrip.ObjectRepository.FlightSearchPage;
import com.sun.javafx.PlatformUtil;
import net.minidev.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public static WebDriver driver = null;

    @BeforeSuite
    public void setup()
    {
        //---get address from pom
        //String baseURL =System.getProperty("sys.cleartrip.baseURL");
        String baseURL= "http://www.cleartrip.com";
        //---block notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        setDriverPath();

        //---initialize the driver
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(driver,FlightSearchPage.class);

        //---launch the site
        driver.get(baseURL);
    }

    @AfterSuite
        public void cleanup()
    {
        driver.quit();
    }


    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

    public void enterValue(WebElement element, String value) throws Exception
    {
        element.clear();
        element.sendKeys(value);
    }
    public void clickOnButton(WebElement element)
    {
        element.click();
    }




}
