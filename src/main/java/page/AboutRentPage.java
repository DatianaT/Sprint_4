package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AboutRentPage extends AbstractPage {
    private final By startRentFieldLocator = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); // Календарь
    private final By datePickerLocator = By.xpath(".//div[@class='react-datepicker']");
    private final By commentFieldLocator = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    private final By rentDurationLocator = By.xpath(".//div[@class= 'Dropdown-placeholder' and text()='* Срок аренды']"); // Срок аренды
    private final By placeOrderButtonLocator = By.xpath("(.//button[text()='Заказать'])[last()]");

    public AboutRentPage(WebDriver driver) {
        super(driver);
    }

    public AboutRentPage fillForm(String rentDurationValue, String colorName) {
        // Choose rent start date
        var startRentField = driver.findElement(startRentFieldLocator);
        startRentField.click();
        driver.findElement(datePickerLocator);
        startRentField.sendKeys(Keys.ENTER);

        // Choose rent duration
        driver.findElement(rentDurationLocator).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + rentDurationValue + "']")).click();

        // Choose color
        driver.findElement(By.xpath(".//label[text()='" + colorName + "']")).click();

        driver.findElement(commentFieldLocator).sendKeys("Спасибо");
        return this;
    }

    public ConfirmOrderPage placeOrder() {
        driver.findElement(placeOrderButtonLocator).click();
        return new ConfirmOrderPage(driver);
    }
}
