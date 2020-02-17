package com.rozetka.bo;

import com.rozetka.pageobjects.HomePO;
import com.rozetka.pageobjects.ResultPO;
import org.openqa.selenium.WebDriver;

public class SearchBO {
    private WebDriver driver;

    public SearchBO(WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchCategoryHeader(String query) {
        HomePO homePO = new HomePO(driver);
        homePO.setQueryToSearchField(query);
        homePO.clickSearchButton();
        return new ResultPO(driver).getSectionHeader();
    }
}
