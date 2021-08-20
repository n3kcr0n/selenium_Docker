package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingAddressPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    public BillingAddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "input_53_addr_line1")
    private WebElement streetAddress_txtbox;

    @FindBy(id = "input_53_addr_line2")
    private WebElement streetAddress_txtbox2;

    @FindBy(id = "input_53_city")
    private WebElement city_txtbox;

    @FindBy(id = "input_53_state")
    private WebElement state_txtbox;

    @FindBy(id = "input_53_postal")
    private WebElement postal_txtbox;

    @FindBy(id = "buyFlights")
    private WebElement continue_btn;

    public void clickContinueButton(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.continue_btn));
        this.continue_btn.click();
    }

    public void enterBillingInformation(String address, String address2, String city, String state, String postal){
        this.streetAddress_txtbox.click();
        this.streetAddress_txtbox.clear();
        this.streetAddress_txtbox.sendKeys(address);

        this.streetAddress_txtbox2.click();
        this.streetAddress_txtbox2.clear();
        this.streetAddress_txtbox2.sendKeys(address2);

        this.city_txtbox.click();
        this.city_txtbox.clear();
        this.city_txtbox.sendKeys(city);

        this.state_txtbox.click();
        this.state_txtbox.clear();
        this.state_txtbox.sendKeys(state);

        this.postal_txtbox.click();
        this.postal_txtbox.clear();
        this.postal_txtbox.sendKeys(postal);
    }
}
