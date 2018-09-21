package com.TestV.Cleartrip.FunctionLibrary;

import com.TestV.Cleartrip.BaseSteps;
import com.TestV.Cleartrip.ObjectRepository.HotelSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HotelBookingOps extends BaseSteps {

    String catcher="";

    public String selectHotelsTab()
    {
        HotelSearchPage hotelSearchPage = PageFactory.initElements(driver,HotelSearchPage.class);
        try
        {
            hotelSearchPage.hotelLink.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String enterLocality(String locality)
    {
        HotelSearchPage hotelSearchPage = PageFactory.initElements(driver,HotelSearchPage.class);
        try
        {
            hotelSearchPage.localityTextBox.clear();
            hotelSearchPage.localityTextBox.sendKeys(locality);
            Thread.sleep(3000);
            List<WebElement> localityDropdownElements = hotelSearchPage.localityDropdown.findElements(By.tagName("li"));
            localityDropdownElements.get(1).click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String selectCheckInDate() throws Exception {
        HotelSearchPage hotelSearchPage = PageFactory.initElements(driver,HotelSearchPage.class);
        try
        {
            DateFormat dateFormat2 = new SimpleDateFormat("dd");
            Date date2 = new Date();

            String today = dateFormat2.format(date2);

            //find the calendar
            List<WebElement> columns=hotelSearchPage.datePicker.findElements(By.tagName("td"));

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

    public String selectCheckOutDate()
    {
        HotelSearchPage hotelSearchPage = PageFactory.initElements(driver,HotelSearchPage.class);
        try
        {
            DateFormat dateFormat2 = new SimpleDateFormat("dd");
            Date date2 = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date2);
            c.add(Calendar.DATE, 1);
            date2 = c.getTime();

            String today = dateFormat2.format(date2);
            //find the calendar
            List<WebElement> columns=hotelSearchPage.datePicker.findElements(By.tagName("td"));

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

    public String select1Room2Adult()
    {
        HotelSearchPage hotelSearchPage = PageFactory.initElements(driver,HotelSearchPage.class);
        try
        {

            Select elem =  new Select(hotelSearchPage.travellerSelection);
            elem.selectByVisibleText("1 room, 2 adults");
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

    public String clickOnHotelSearchButton ()
    {
        HotelSearchPage hotelSearchPage = PageFactory.initElements(driver,HotelSearchPage.class);
        try
        {
            hotelSearchPage.searchButton.click();
        }
        catch (Exception e)
        {
            return e.getClass().getName();
        }

        return catcher;
    }

}
