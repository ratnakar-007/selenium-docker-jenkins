package com.searchmodule.tests;

import com.basetest.BaseTest;
import com.searchModulePages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

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


}
