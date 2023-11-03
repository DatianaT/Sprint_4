package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {
    private final By headerLocator = By.className("Home_Header__iJKdX");
    private final By questionsLocator = By.className("accordion");

    public MainPage(WebDriver driver) {
        super(driver);

        var gotHeaderText = driver.findElement(headerLocator).getText();
        var wantHeaderText = "Самокат\n" +
                "на пару дней\n" +
                "Привезём его прямо к вашей двери,\n" +
                "а когда накатаетесь — заберём";
        Assertions.assertEquals(wantHeaderText, gotHeaderText);

        driver.findElement(By.xpath(".//button[text()='да все привыкли']")).click();
    }

    public CreateOrderPage toOrder() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        return new CreateOrderPage(driver);
    }

    public CreateOrderPage toOrderBySecondButton() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        return new CreateOrderPage(driver);
    }

    public MainPage scrollToQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsLocator));
        return this;
    }

    public String getAnswerForQuestion(String question) {
        var questionItemElement = driver.findElement(questionsLocator)
                .findElement(By.xpath(".//div[text()='" + question + "']/parent::div/parent::div"));

        var questionButtonElement = questionItemElement
                .findElement(By.className("accordion__button"));
        questionButtonElement.click();

        var answerElement = questionItemElement.findElement(By.xpath(".//div[@class='accordion__panel']/p"));
        return answerElement.getText();
    }
}
