package com.TestV.Cleartrip.FunctionLibrary;

import com.TestV.Cleartrip.BaseSteps;
import com.TestV.Cleartrip.ObjectRepository.SignInPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.sun.jmx.snmp.ThreadContext.contains;

public class SignInOps extends BaseSteps {
    String catcher="";

    public String ClickOnYourTrips()
    {
        try {
            SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
            signInPage.YoutTrips.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String ClickOnSignInLink()
    {
        try {
            SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
            signInPage.SignIn.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String ClickOnSignInButton()
    {
        try {
            driver.switchTo().frame("modal_window");
            SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
            signInPage.SignInButton.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String ValidateErrorMsg()
    {
        try {
            SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
            String errTxt = signInPage.ErrorsField.getText();
            Assert.assertTrue(errTxt.contains("There were errors in your submission"));

        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }
}
