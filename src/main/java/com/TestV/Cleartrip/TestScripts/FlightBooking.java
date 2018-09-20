package com.TestV.Cleartrip.TestScripts;
import com.TestV.Cleartrip.BaseSteps;
import com.TestV.Cleartrip.FunctionLibrary.FlightSearchOps;
import com.TestV.Cleartrip.ObjectRepository.FlightSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBooking extends BaseSteps{
   FlightSearchOps flightSearchOps = new FlightSearchOps();
   String catcher="";

 @Test
   public void testSearchingForFlights() throws Exception {

//call the function to select one way and check for errors
        catcher = flightSearchOps.selectOneway();
            if(catcher!="")
            {
                System.out.println("Error selecting the button. Reason "+catcher);
                Assert.fail();
            }
            else System.out.println("selected one way");

//enter from city and select first element from dropdown
        catcher = flightSearchOps.enterFromCity("Bangalore");
            if(catcher!="")
            {
                System.out.println("Error entering from city. Reason "+catcher);
                Assert.fail();
            }
            else System.out.println("Entered from city");

//enter to city and select first element
        catcher = flightSearchOps.enterToCity("Delhi");
            if(catcher!="")
             {
                 System.out.println("Error entering to city. Reason "+catcher);
                 Assert.fail();
             }
             else System.out.println("Entered to city");

//select todays date
        catcher = flightSearchOps.selectTodaysDate();
         if(catcher!="")
         {
             System.out.println("Error selecting today's date. Reason "+catcher);
             Assert.fail();
         }
         else System.out.println("Selected today's date");

//click on search button
         catcher = flightSearchOps.clickOnSearch();
         if(catcher!="")
         {
             System.out.println("Error clicking on search button. Reason "+catcher);
             Assert.fail();
         }
         else System.out.println("Clicked on search button");

//verify that search results appear
         catcher = flightSearchOps.verifyThatResultsAppeared();
         if(catcher!="")
         {
             System.out.println("Result page did not appear. Reason "+catcher);
             Assert.fail();
         }
         else System.out.println("Results rendered successfully");
   }
}
