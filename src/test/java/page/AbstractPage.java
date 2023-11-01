package page;

import org.openqa.selenium.WebDriver;
public abstract class AbstractPage {
    final protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
