import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import page.MainPage;

public class TestOrderSuite extends AbstractTestSuite {
    @DisplayName("Make Order")
    @ParameterizedTest
    @CsvFileSource(resources = "orders.csv", numLinesToSkip = 1)
    public void testMakeOrder(
            String firstName,
            String lastName,
            String address,
            String metro,
            String phoneNumber,
            String rentDuration,
            String color
    ) {
        var mainPage = new MainPage(driver);
        var orderPage = mainPage.toOrder();

        orderPage.fillFirstName(firstName);
        orderPage.fillLastName(lastName);
        orderPage.fillAddress(address);
        orderPage.chooseMetroStation(metro);
        orderPage.fillPhoneNumber(phoneNumber);

        var aboutRentPage = orderPage.next();
        aboutRentPage.fillForm(rentDuration, color);

        var confirmOrderPage = aboutRentPage.placeOrder();
        confirmOrderPage.confirm();
    }

    @DisplayName("Make Order second button")
    @Test
    public void testMakeOrderButtonWorks() {
        var mainPage = new MainPage(driver);
        mainPage.toOrderBySecondButton();
    }
}
