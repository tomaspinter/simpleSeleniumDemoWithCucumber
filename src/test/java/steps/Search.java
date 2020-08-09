package steps;

import io.cucumber.java8.En;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BlogPage;
import pages.HomePage;
import pages.SearchResultsPage;
import setup.FFDriver;

public class Search implements En {

    public FirefoxDriver driver;
    public HomePage homePage;
    public BlogPage blogPage;
    public SearchResultsPage searchResultsPage;

    public Search() {

        Before(() -> {
            driver = new FFDriver().getDriver();
        });

        Given("I navigate to CIIT homepage", () -> {
            driver.get("https://ciit.at/");
            homePage = new HomePage(driver);
        });

        Then("I should see the company logo", () -> {
            homePage.logo.isDisplayed();
        });

        When("I switch to the blog page", () -> {
            homePage.mainMenu.blog.click();
            blogPage = new BlogPage(driver);
        });

        And("scroll to the search field", () -> {
            Thread.sleep(2000);
            blogPage.scrollToSearchView();
        });

        And("I click the search input field", () -> {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(blogPage.searchInput));
            blogPage.searchInput.click();
        });

        And("the field gains focus", () -> {
            blogPage.searchInput.equals(driver.switchTo().activeElement());
        });

        /*
        I used java 13, when trying to use regexp:
        IllegalStateException: Could resolve the return type of the lambda at Search.java:61
        This version of cucumber-java8 is not compatible with Java 12+
        See: https://github.com/cucumber/cucumber-jvm/issues/1817
         */
        When("^I type in java$", () -> {
            blogPage.searchInput.sendKeys("java");
        });

        And("the live search list appears", () -> {
            blogPage.searchLiveResultsList.isDisplayed();
        });

        And("I confirm my search via pressing the enter key", () -> {
            blogPage.searchInput.sendKeys(Keys.ENTER);
        });

        Then("I will be redirected to a new page", () -> {
            Thread.sleep(2000);
            searchResultsPage = new SearchResultsPage(driver);
        });

        Then("the results will be listed", () -> {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(searchResultsPage.searchResults));
            searchResultsPage.searchResults.isDisplayed();
        });

        After(() -> {
            driver.quit();
        });

    }
}
