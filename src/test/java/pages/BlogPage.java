package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage extends Page {

    private static final String pageTitle = "CIIT Softwareentwicklung Blog - CIIT Software";

    public WebElement searchInput;
    public WebElement searchLiveResultsList;

    public BlogPage(WebDriver driver) {
        super(driver, pageTitle);
        searchInput = driver.findElement(By.cssSelector("#search-3 input"));
        searchLiveResultsList = driver.findElement(By.xpath("//*[@class='search-live-results'][1]"));
    }

    public void scrollToSearchView() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchInput);
    }
}