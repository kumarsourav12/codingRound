package com.TestV.Cleartrip.TestScripts;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class SignInTest {

    private static Object firstHandle;
    private static Object lastHandle;
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws InterruptedException {
        setDriverPath();
        WebDriver driver = new ChromeDriver();
        System.out.println("before set drive path");
        //setDriverPath();

        System.out.println("after set drive path");
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        Thread.sleep(5000);
       driver.switchTo().activeElement();

        //driver.findElement(By.id("signInButton")).click();
        driver.findElement(By.xpath("//*[@id=\"signInButton\"]"));

        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "D:\\TestV_Coding\\chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }}

        public static void switchToWindowsPopup(WebDriver driver) {
            Set<String> handles = driver.getWindowHandles();
            Iterator<String> itr = handles.iterator();
            firstHandle = itr.next();
            lastHandle = firstHandle;
            while (itr.hasNext()) {
                lastHandle = itr.next();
            }
            driver.switchTo().window(lastHandle.toString());
        }




}
