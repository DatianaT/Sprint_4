import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import page.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSuite {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        var url = dotenv.get("URL", "");

        var wdm = WebDriverManager.chromedriver();
//        var wdm = WebDriverManager.firefoxdriver();

        driver = wdm.create();
        driver.get(url);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @DisplayName("Make Order")
    @ParameterizedTest
    @CsvFileSource(resources = "users.csv", numLinesToSkip = 1)
    public void testMakeOrder(String firstName, String lastName, String address, String metro, String phoneNumber) {
        var mainPage = new MainPage(driver);
        var orderPage = mainPage.toOrder();

        orderPage.fillFirstName(firstName);
        orderPage.fillLastName(lastName);
        orderPage.fillAddress(address);
        orderPage.chooseMetroStation(metro);
        orderPage.fillPhoneNumber(phoneNumber);

        var aboutRentPage = orderPage.next();
        aboutRentPage.fillForm();

        var confirmOrderPage = aboutRentPage.next();
        confirmOrderPage.confirm();
    }

    @DisplayName("Make Order second button works")
    @Test
    public void testMakeOrderButtonWorks() {
        var mainPage = new MainPage(driver);
        mainPage.toOrderBySecondButton();
    }

    @DisplayName("Test question has correct answer")
    @ParameterizedTest
    @CsvFileSource(resources = "questions.csv", numLinesToSkip = 1)
    public void dropdownListPageCheck(String question, String answer) {
        var mainPage = new MainPage(driver);
        mainPage.scrollToQuestions();

        var gotAnswer = mainPage.getAnswerForQuestion(question);
        assertEquals(answer, gotAnswer);
    }
}
