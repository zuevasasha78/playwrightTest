package org.playwrightTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGoogle extends BaseTest {

    private final static String SEARCH_WORD = "everx labs";

    @BeforeEach
    public void openChrome() {
        page.navigate(URL);
    }

    @DisplayName("Search with not empty query")
    @Test
    public void searchText() {
        String textExpected = "EverX - Runa Capital";

        mainPaige.typeSearchText(SEARCH_WORD);
        mainPaige.startSearch();

        page.waitForLoadState();

        assertTrue(searchPage.getHeaderLink().isVisible(), "Link in header not exist");
        assertTrue(searchPage.getDescriptionResult().isVisible(), "Description not exist");
        assertTrue(searchPage.getTextResult().isVisible(), "Text not exist");
        assertTrue(searchPage.getTextResult().textContent().equals(textExpected),
                "Text not as expected");
    }

    @DisplayName("Search query as I am lucky")
    @Test
    public void searchTextAsIAmLucky() {
        String expectedUrl = "https://runacap.com/companies/everx/";

        mainPaige.typeSearchText(SEARCH_WORD);
        mainPaige.clickIAmLucky();

        assertTrue(page.url().equals(expectedUrl));
    }

    @DisplayName("Search with empty query")
    @Test
    public void searchWithEmptyQuery() {
        mainPaige.typeSearchText("");
        page.keyboard().press("Enter");
        page.waitForLoadState();

        assertTrue(searchPage.getHeaderLink() == null, "Link in header is exist");
        assertTrue(page.url().equals(URL));
    }
}
