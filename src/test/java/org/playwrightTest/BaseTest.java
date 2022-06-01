package org.playwrightTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.playwrightTest.paiges.MaiPaige;
import org.playwrightTest.paiges.SearchPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    protected static final String URL = "https://www.google.com/";
    protected MaiPaige mainPaige;
    protected SearchPage searchPage;
    protected Page page;
    private Browser browser;

    @BeforeAll
    public void startBrowser() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch();
        page = browser.newPage();

        mainPaige = new MaiPaige(page);
        searchPage = new SearchPage(page);
    }

    @AfterAll
    public void closeBrowser() {
        browser.close();
    }
}
