package com.newtour.tests;

import com.newtour.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest {

    private WebDriver driver;
    private String noOfPassngers;
    private String expPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setUp(String nop, String price) {
        this.noOfPassngers = nop;
        this.expPrice = price;

        //set path
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
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
        fdp.selectPassengers(noOfPassngers);
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

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
