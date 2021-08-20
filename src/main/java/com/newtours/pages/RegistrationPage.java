package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private final WebDriverWait wait;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }
    @FindBy(name="firstName")
    private WebElement firstName_TxtBox;

    @FindBy(name="lastName")
    private WebElement lastName_TxtBox;

    @FindBy(id = "email")
    private WebElement email_TxtBox;

    @FindBy(name = "password")
    private WebElement password_TxtBox;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword_TxtBox;

    @FindBy(id = "register-btn")
    private WebElement submit_Btn;

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        this.wait.until(ExpectedConditions.visibilityOf(firstName_TxtBox));
    }

     public void enterUserDetails(String firstName,String lastName){
        this.firstName_TxtBox.sendKeys(firstName);
        this.lastName_TxtBox.sendKeys(lastName);
     }

     public void enterUserCredentials(String userName,String password){
        this.email_TxtBox.sendKeys(userName);
        this.password_TxtBox.sendKeys(password);
        this.confirmPassword_TxtBox.sendKeys(password);
     }

     public void submit(){
        this.submit_Btn.click();
     }
}
