package com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(name = "email")
    private WebElement userNameField;

    @FindBy(name = "password")
    private WebElement pwdField;

    @FindBy(name = "confirmPassword")
    private WebElement cnfmPwdField;

    @FindBy(id = "register-btn")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("http://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.driver.manage().window().maximize();
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameField));
    }

    public void enterUserDetails(String firstName, String lastName) {
        this.firstNameField.sendKeys(firstName);
        this.lastNameField.sendKeys(lastName);
    }

    public void enterUserCred(String userName, String passWord) {
        this.userNameField.sendKeys(userName);
        this.pwdField.sendKeys(passWord);
        this.cnfmPwdField.sendKeys(passWord);
    }

    public void submit(){
        this.submitBtn.click();
    }

}
