package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends Page {

    private static final String pageTitle = "You searched for - CIIT Software";

    public WebElement searchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver, pageTitle);
        searchResults = driver.findElement(By.cssSelector("#Content .posts_group"));
    }


}
