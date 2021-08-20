package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
    private WebDriver driver;
    private final WebDriverWait wait;
    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    @FindBy(partialLinkText= "sign-in")
    private WebElement signIn_linkText;

    @FindBy(linkText = "Flights")
    private WebElement flight_linkText;

    public void goToFlightDetailsPage(){
        this.wait.until(ExpectedConditions.visibilityOf(signIn_linkText));
        this.flight_linkText.click();
    }
}
