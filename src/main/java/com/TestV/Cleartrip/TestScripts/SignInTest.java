package com.TestV.Cleartrip.TestScripts;

import com.TestV.Cleartrip.BaseSteps;
import com.TestV.Cleartrip.FunctionLibrary.SignInOps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseSteps{
    SignInOps signInOps=  new SignInOps();
    String catcher = "";
    @Test
    public void testSignIn()
    {
        catcher = signInOps.ClickOnYourTrips();
        if(catcher!="")
        {
            System.out.println("Unable to click on Your Trips "+catcher);
            Assert.fail();
        }
        else System.out.println("Clicked on Your Trips link");

        catcher = signInOps.ClickOnSignInLink();
        if(catcher!="")
        {
            System.out.println("Unable to click on sign in link "+catcher);
            Assert.fail();
        }
        else System.out.println("Clicked on sign in link");

        catcher = signInOps.ClickOnSignInButton();
        if(catcher!="")
        {
            System.out.println("Unable to click on sing in button "+catcher);
            Assert.fail();
        }
        else System.out.println("Clicked on sign in button");

        catcher = signInOps.ValidateErrorMsg();
        if(catcher!="")
        {
            System.out.println("Not able to validate the error message "+catcher);
            Assert.fail();
        }
        else System.out.println("Verified the error message");
    }
}
