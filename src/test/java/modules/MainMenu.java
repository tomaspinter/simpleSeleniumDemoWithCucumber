package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainMenu {

    public WebDriver driver;

    public WebElement home;
    public WebElement development;
    public WebElement blog;

    public MainMenu(WebDriver driver) {
        this.driver = driver;
        home = driver.findElement(By.xpath("//ul[@id='menu-main-menu']/li/a/span[text()='CIIT']"));
        blog = driver.findElement(By.xpath("//ul[@id='menu-main-menu']/li/a/span[text()='BLOG']"));
        development = driver.findElement(By.xpath("//ul[@id='menu-main-menu']/li/a/span[text()='ENTWICKLUNG']"));
        //...
    }
}
