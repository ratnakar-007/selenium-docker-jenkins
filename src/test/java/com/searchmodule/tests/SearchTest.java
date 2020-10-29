package com.searchmodule.tests;

import com.searchModulePages.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest {
    private WebDriver driver;

    @BeforeTest
    public void setUpDriver() {

        //set path
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @Test
    @Parameters({"searchKeyword"})
    public void search(String keyword) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.search(keyword);
        searchPage.goToVideos();
        int vidCount = searchPage.getVideosCount();
        Assert.assertTrue(vidCount > 0);
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }
}
