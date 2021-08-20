package com.searchduckduckgo.test;

import DriverManager.DriverManager;
import PageManager.PageManager;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends DriverManager {

    @Test
    void GoToApplicationTest(){
        PageManager.seachPage.goToDuckDuckGoSearchPage();
    }

    @Parameters({"searchText"})
    @Test(dependsOnMethods = "GoToApplicationTest")
    void SearchTest(String searchText){
        PageManager.seachPage.search(searchText);
    }

    @Test(dependsOnMethods = "SearchTest")
    void checkVideoResults(){
        PageManager.seachPage.goToVideoResult();
        Assert.assertNotEquals(PageManager.seachPage.getSearchVideoResults(),"0");
    }
}
