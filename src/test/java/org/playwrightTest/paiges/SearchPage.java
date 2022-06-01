package org.playwrightTest.paiges;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class SearchPage {

    private Page page;

    public SearchPage(Page page) {
        this.page = page;
    }

    private String headerResult = "//*[@id=\"rso\"]/div[1]/div/div[1]/div/a/div/cite";
    private String descriptionResult = "//*[@id=\"rso\"]/div[1]/div/div[2]";
    private String textResult = "//*[@id=\"rso\"]/div[1]/div/div[1]/div/a/h3";

    public ElementHandle getHeaderLink() {
        return page.querySelector(headerResult);
    }

    public ElementHandle getDescriptionResult() {
        return page.querySelector(descriptionResult);
    }

    public ElementHandle getTextResult() {
        return page.querySelector(textResult);
    }}
