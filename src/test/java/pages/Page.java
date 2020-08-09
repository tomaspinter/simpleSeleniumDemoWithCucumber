package pages;

import org.openqa.selenium.WebDriver;

public class Page {

    public WebDriver driver;
    public String title;

    public Page (WebDriver driver) {
        this.driver = driver;
    }

    public Page (WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
        checkTitle();
    }

    protected void checkTitle() {
        if (!driver.getTitle().equals(title)) {
            throw new IllegalStateException(
                    "Landed on: " + driver.getTitle() + " @ " + driver.getCurrentUrl() +
                    ". This is not the '" + title + "' page!"
            );
        }
    }
}
