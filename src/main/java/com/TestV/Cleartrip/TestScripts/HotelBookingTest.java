package com.TestV.Cleartrip.TestScripts;
import com.TestV.Cleartrip.FunctionLibrary.HotelBookingOps;
import com.TestV.Cleartrip.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseSteps{
    String catcher="";

    @Test
    public void testHotelBooking() throws Exception {
        HotelBookingOps hotelBookingOps = new HotelBookingOps();

        catcher = hotelBookingOps.selectHotelsTab();
        if(catcher!="")
        {
            System.out.println("Unable to select hotels tab. Reason "+catcher);
            Assert.fail();
        }
        else System.out.println("selected hotels tab");

        catcher = hotelBookingOps.enterLocality("Bangalore");
        if(catcher!="")
        {
            System.out.println("Unable to enter locality. Reason "+catcher);
            Assert.fail();
        }
        else System.out.println("Entered locality as Bangalore");

        catcher = hotelBookingOps.selectCheckInDate();
        if(catcher!="")
        {
            System.out.println("Unable to enter check in date. Reason "+catcher);
            Assert.fail();
        }
        else System.out.println("Entered check in date");
        Thread.sleep(1000);

        catcher = hotelBookingOps.selectCheckOutDate();
        if(catcher!="")
        {
            System.out.println("Unable to enter checkout date. Reason "+catcher);
            Assert.fail();
        }
        else System.out.println("Entered check out date");

        catcher = hotelBookingOps.select1Room2Adult();
        if(catcher!="")
        {
            System.out.println("Unable to select rooms "+catcher);
            Assert.fail();
        }
        else System.out.println("Entered rooms");

        catcher = hotelBookingOps.clickOnHotelSearchButton();
        if(catcher!="")
        {
            System.out.println("Unable to click on search button. Reason "+catcher);
            Assert.fail();
        }
        else System.out.println("Clicked on search button");
    }

}
