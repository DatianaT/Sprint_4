package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentPage extends AbstractPage {
   private final By calendar = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); // Календарь
   private final By rentDuration = By.xpath(".//div[@class= 'Dropdown-placeholder' and text()='* Срок аренды']"); // Срок аренды
    private final By orderDate = By.xpath(".//div[@class = 'react-datepicker']//div[text()='29']"); // 29 октября
    public AboutRentPage(WebDriver driver) {
        super(driver);
    }

    public AboutRentPage fillForm() {
        driver.findElement(calendar).click();
        driver.findElement(orderDate).click();

        driver.findElement(rentDuration).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']")).click();

        driver.findElement(By.className("Order_Title__3EKne")).click();
        driver.findElement(By.id("black")).click();
        driver.findElement(By.xpath(".//input[@placeholder='Комментарий для курьера']")).sendKeys("Спасибо");


        return this;
    }
    public ConfirmOrderPage next() {
        driver.findElement(By.xpath("(.//button[text()='Заказать'])[last()]")).click();
        return new ConfirmOrderPage(driver);
    }
}
