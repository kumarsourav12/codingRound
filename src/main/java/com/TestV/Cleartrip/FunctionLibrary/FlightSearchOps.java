package com.TestV.Cleartrip.FunctionLibrary;
import com.TestV.Cleartrip.BaseSteps;
import com.TestV.Cleartrip.ObjectRepository.FlightSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FlightSearchOps extends BaseSteps{
    static BaseSteps baseSteps;
    String catcher="";

    FlightSearchPage flightSearchPage;


    public String selectOneway() throws InterruptedException {
        FlightSearchPage flightSearchPage = PageFactory.initElements(driver,FlightSearchPage.class);
       try
        {
           flightSearchPage.travelType_oneWay.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;

    }

    public String selectRoundTrip()
    {
        FlightSearchPage flightSearchPage = PageFactory.initElements(driver,FlightSearchPage.class);
        try
        {
            flightSearchPage.travelType_roundTrip.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }
    public String selectMultiCity()
    {
        FlightSearchPage flightSearchPage = PageFactory.initElements(driver,FlightSearchPage.class);
        try
        {
            flightSearchPage.travelType_multiCity.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }
    public String enterFromCity(String fromCity) {
        FlightSearchPage flightSearchPage = PageFactory.initElements(driver,FlightSearchPage.class);
        try
        {
            flightSearchPage.fromCity.clear();
            flightSearchPage.fromCity.sendKeys(fromCity);

            List<WebElement> fromCityDropdownElements = flightSearchPage.fromCityDropdown.findElements(By.tagName("li"));
            fromCityDropdownElements.get(0).click();

        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String enterToCity(String toCity) throws Exception {
        FlightSearchPage flightSearchPage = PageFactory.initElements(driver,FlightSearchPage.class);
        try
        {
            flightSearchPage.toCity.clear();
            flightSearchPage.toCity.sendKeys(toCity);


            List<WebElement> fromCityDropdownElements = flightSearchPage.toCityDropdown.findElements(By.tagName("li"));
            fromCityDropdownElements.get(0).click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String selectTodaysDate() throws Exception
    {
        FlightSearchPage flightSearchPage = PageFactory.initElements(driver,FlightSearchPage.class);
        try
        {
            DateFormat dateFormat2 = new SimpleDateFormat("dd");
            Date date2 = new Date();

            String today = dateFormat2.format(date2);

            //find the calendar
            List<WebElement> columns=flightSearchPage.datePicker.findElements(By.tagName("td"));

            //comparing the text of cell with today's date and clicking it.
            for (WebElement cell : columns)
            {
                if (cell.getText().equals(today))
                {
                    cell.click();
                    break;
                }
            }
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String clickOnSearch() throws Exception
    {
        FlightSearchPage flightSearchPage = PageFactory.initElements(driver,FlightSearchPage.class);
        try
        {
            flightSearchPage.searchFlight.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String verifyThatResultsAppeared() throws Exception {
        FlightSearchPage flightSearchPage = PageFactory.initElements(driver, FlightSearchPage.class);
        try {
            flightSearchPage.resultPage.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }
        return catcher;

    }

}
