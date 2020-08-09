package setup;

import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;

public class FFDriver {

    private FirefoxDriver driver;
    private static final String geckoPath = "src/test/resources/geckodriver.exe";

    public FFDriver() {
        launch();
    }

    public FirefoxDriver getDriver() {
        return this.driver;
    }

    private String getDriverPath()  {
        File path = new File(geckoPath);
        System.out.println(path.getAbsolutePath());
        return path.getAbsolutePath();
    }

    private void launch () {
        System.setProperty("webdriver.gecko.driver", getDriverPath());
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
}
