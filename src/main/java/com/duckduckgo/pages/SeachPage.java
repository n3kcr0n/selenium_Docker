package com.duckduckgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeachPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    public SeachPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "q")
    private WebElement search_textbox;

    @FindBy(id = "search_button_homepage")
    private WebElement searchIcon_btn;

    @FindBy(linkText = "Videos")
    private WebElement videosResult_link;

    @FindBy(className = "tile--vid")
    By videosList = By.className("tile--vid");
    private List<WebElement> videosResult_list;

    public void goToDuckDuckGoSearchPage(){
        this.driver.get("https://duckduckgo.com/?q=&t=h_");
        this.wait.until(ExpectedConditions.visibilityOf(this.search_textbox));
    }

    public void search(String searchText){
        this.wait.until(ExpectedConditions.visibilityOf(this.search_textbox));
        this.wait.until(ExpectedConditions.elementToBeClickable(this.searchIcon_btn));
        this.search_textbox.clear();
        this.search_textbox.sendKeys(searchText);
        this.searchIcon_btn.click();
    }

    public void goToVideoResult(){
        this.videosResult_link.click();
    }

    public String getSearchVideoResults(){
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(videosList,0));
        return Integer.toString(this.videosResult_list.size());
    }
}
