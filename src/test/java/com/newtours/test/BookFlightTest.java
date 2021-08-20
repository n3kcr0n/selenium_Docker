package com.newtours.test;
import DriverManager.DriverManager;
import PageManager.PageManager;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BookFlightTest extends DriverManager {
    String uname = PageManager.loremGenerator.getName();
    String lname = PageManager.loremGenerator.getLastName();
    String pass = uname+lname;
    String address = PageManager.loremGenerator.getStateFull();
    String city = PageManager.loremGenerator.getCity();
    String state = PageManager.loremGenerator.getStateAbbr();
    String postcode = PageManager.loremGenerator.getZipCode();

    @Test
    void RegistrationTest(){
        PageManager.registrationPage.goTo();
        PageManager.registrationPage.enterUserDetails(uname,lname);
        PageManager.registrationPage.enterUserCredentials(uname,pass);
        PageManager.registrationPage.submit();
    }

    @Test(dependsOnMethods ="RegistrationTest")
    void RegistrationConfirmationTest(){
        PageManager.registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Parameters({ "noOfPassengers" })
    @Test(dependsOnMethods = "RegistrationConfirmationTest")
    void FlightDetailsTest(String noOfPassengers ){
        PageManager.flightDetailsPage.selectPassengerCount(noOfPassengers);
        PageManager.flightDetailsPage.selectDepartingPlace("London");
        PageManager.flightDetailsPage.selectArrivalPlace("Sydney");
        PageManager.flightDetailsPage.selectReturnDay("30");
        PageManager.flightDetailsPage.selectReturningMonth("12");
        PageManager.flightDetailsPage.clickFindFlightsButton();
    }

    @Test(dependsOnMethods = "FlightDetailsTest")
    void FindFlightPageTest(){
        PageManager.findFlightsPage.submitFindFlightsPage();
    }

    @Test(dependsOnMethods = "FindFlightPageTest")
    void BillingAddressPageTest (){
        PageManager.billingAddressPage.enterBillingInformation(address,address,city,state,postcode);
        PageManager.billingAddressPage.clickContinueButton();
    }

    @Parameters({ "expectedPrice" })
    @Test(dependsOnMethods = "BillingAddressPageTest")
    void FlightConfirmationTest(String expectedPrice){
        String actualPrice = PageManager.flightConfirmationPage.checkBookingConfirmation();
        Assert.assertEquals(actualPrice,expectedPrice);
    }
}
