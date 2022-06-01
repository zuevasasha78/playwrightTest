package org.playwrightTest.paiges;

import com.microsoft.playwright.Page;

public class MaiPaige {

    private Page page;

    public MaiPaige(Page page) {
        this.page = page;
    }

    private String inputElementLocator = "input.gLFyf.gsfi";
    private String searchElement = "input.gNO89b";
    private String iAmLucky = "input.RNmpXc";

    public void typeSearchText(String searchText) {
        page.type(inputElementLocator, searchText);
    }

    public void startSearch() {
        page.querySelector(searchElement).click();
    }

    public void clickIAmLucky() {
        page.querySelector(iAmLucky).click();
    }
}
