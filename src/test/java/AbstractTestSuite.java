import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

abstract class AbstractTestSuite {
    protected WebDriver driver;
    private WebDriverManager wdm;

    @BeforeEach
    void setup() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        var url = dotenv.get("URL", "");

        wdm = WebDriverManager.chromedriver();
//        wdm = WebDriverManager.firefoxdriver();

        driver = wdm.create();
        driver.get(url);
    }

    @AfterEach
    void teardown() {
        wdm.quit();
    }
}
