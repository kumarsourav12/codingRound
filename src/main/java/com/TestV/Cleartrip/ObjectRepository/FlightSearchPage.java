package com.TestV.Cleartrip.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchPage {
    @FindBy(id="OneWay")
    public static WebElement travelType_oneWay;

    @FindBy(id="RoundTrip")
    public WebElement travelType_roundTrip;

    @FindBy(id="MultiCity")
    public WebElement travelType_multiCity;

    @FindBy(id="FromTag")
    public  WebElement fromCity;

    @FindBy(id="ui-id-1")
    public WebElement fromCityDropdown;

    @FindBy(id="ui-id-2")
    public WebElement toCityDropdown;

    @FindBy(id="ToTag")
    public WebElement toCity;

    @FindBy(id="ui-datepicker-div")
    public WebElement datePicker;

    @FindBy(id="SearchBtn")
    public WebElement searchFlight;

    @FindBy(className = "searchSummary")
    public WebElement resultPage;
}
