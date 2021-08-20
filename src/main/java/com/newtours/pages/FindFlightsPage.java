package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightsPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    public FindFlightsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "reserveFlights")
    private WebElement continue_btn;

    public void submitFindFlightsPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.continue_btn));
        this.continue_btn.click();
    }

}
