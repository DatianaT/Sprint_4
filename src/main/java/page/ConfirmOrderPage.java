package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPage extends AbstractPage {
    public ConfirmOrderPage(WebDriver driver) {
        super(driver);
    }

    public void confirm() {
        driver.findElement(By.xpath(".//button[text()='Да']")).click();
        driver.findElement(By.xpath(".//button[text()='Посмотреть статус']")).click();
    }
}
