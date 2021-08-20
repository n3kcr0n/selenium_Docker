package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
    private WebDriver driver;
    private final WebDriverWait wait;
    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "passCount")
    private WebElement passengerCount_select;

    @FindBy(name = "fromPort")
    private WebElement departingPlace_select;

    @FindBy(name = "toPort")
    private WebElement arrivingPlace_select;

    @FindBy(name = "toDay")
    private WebElement returningDay_select;

    @FindBy(name = "toMonth")
    private WebElement returningMonth_select;

    @FindBy(name = "findFlights")
    private WebElement findFlights_btn;

    public void selectPassengerCount(String count){
        this.wait.until(ExpectedConditions.visibilityOf(passengerCount_select));
        Select selectPassenger = new Select(passengerCount_select);
        selectPassenger.selectByValue(count);
    }

    public void selectDepartingPlace(String departingPlace){
        Select selectDeparturePlace = new Select(departingPlace_select);
        selectDeparturePlace.selectByValue(departingPlace);
    }

    public void selectArrivalPlace(String arrivalPlace){
        Select selectArrivalPlace = new Select(arrivingPlace_select);
        selectArrivalPlace.selectByValue(arrivalPlace);
    }

    public void selectReturningMonth(String month){
        Select returnMonth = new Select(returningMonth_select);
        returnMonth.selectByValue(month);
    }

    public void selectReturnDay(String day){
        Select returnDay = new Select(returningDay_select);
        returnDay.selectByValue(day);
    }

    public void clickFindFlightsButton(){
        this.findFlights_btn.click();
    }
}
