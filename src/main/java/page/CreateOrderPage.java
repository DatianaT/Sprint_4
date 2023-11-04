package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CreateOrderPage extends AbstractPage {
    public CreateOrderPage(WebDriver driver) {
        super(driver);

        driver.findElement(By.xpath(".//div[text()='Для кого самокат']"));
    }

    public CreateOrderPage fillFirstName(String firstName) {
        driver.findElement(By.xpath(".//input[@placeholder='* Имя']")).sendKeys(firstName);
        return this;
    }

    public CreateOrderPage fillLastName(String lastName) {
        driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']")).sendKeys(lastName);
        return this;
    }

    public CreateOrderPage fillAddress(String address) {
        driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys(address);
        return this;
    }

    public CreateOrderPage chooseMetroStation(String name) {
        driver.findElement(By.className("select-search__input")).click();
        var targetMetro = driver.findElement(By.xpath(".//div[text()='" + name + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", targetMetro);
        targetMetro.click();
        return this;
    }

    public CreateOrderPage fillPhoneNumber(String phoneNumber) {
        driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"))
                .sendKeys(phoneNumber);
        return this;
    }

    public AboutRentPage next() {
        driver.findElement(By.xpath(".//button[text()='Далее']")).click();
        return new AboutRentPage(driver);
    }
}
