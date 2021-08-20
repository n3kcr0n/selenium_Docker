package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.List;

public class FlightConfirmationPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement flightConfirmation_text;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;

    @FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]")
    private WebElement signoff_link;

    public String checkBookingConfirmation(){
        String prices = "";
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmation_text));
        this.wait.until(ExpectedConditions.visibilityOf(this.prices.get(1)));
        prices = this.prices.get(1).getText();
        this.signoff_link.click();
        System.out.println("BOOKING PRICE: " + prices);
        return prices;
    }

}
