package com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement firstCntnuBtn;

    @FindBy(name = "buyFlights")
    private WebElement scndCntnuBtn;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void submitFindFlightPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(firstCntnuBtn));
        this.firstCntnuBtn.click();
    }

    public void goToFlightConfirmationPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(scndCntnuBtn));
        this.scndCntnuBtn.click();
    }
}
