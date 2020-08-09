package pages;

import modules.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {

    private static final String pageTitle = "Individuelle Software Entwicklung, Beratung & Lösungen";

    public WebElement logo;

    public MainMenu mainMenu;

    public HomePage(WebDriver driver) {
        super(driver, pageTitle);
        mainMenu = new MainMenu(driver);
        logo = driver.findElement(By.id("logo"));
    }
}
