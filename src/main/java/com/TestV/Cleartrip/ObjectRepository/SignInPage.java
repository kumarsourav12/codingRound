package com.TestV.Cleartrip.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
    @FindBy(linkText = "Your trips")
    public WebElement YoutTrips;

    @FindBy(id="SignIn")
    public WebElement SignIn;

    @FindBy(id="signInButton")
    public WebElement SignInButton;

    @FindBy(id="errors1")
    public WebElement ErrorsField;
}
