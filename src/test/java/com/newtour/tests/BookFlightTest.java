package com.newtour.tests;

import com.basetest.BaseTest;
import com.newtour.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setUpParameters(String nop, String price) {
        this.noOfPassengers = nop;
        this.expPrice = price;
    }

    @Test
    public void registrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCred("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationTest() {
        RegistrationConfirmationPage rcp = new RegistrationConfirmationPage(driver);
        rcp.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightDetailsTest() {
        FlightDetailsPage fdp = new FlightDetailsPage(driver);
        fdp.selectPassengers(noOfPassengers);
        fdp.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsTest")
    public void findFlightTest() {
        FindFlightPage ffp = new FindFlightPage(driver);
        ffp.submitFindFlightPage();
        ffp.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightTest")
    public void flightConfirmationTest() {
        FlightConfirmationPage fcp = new FlightConfirmationPage(driver);
        String actPrice = fcp.getPrizeAtConfirmation();
        Assert.assertEquals(actPrice, expPrice);
    }
}
