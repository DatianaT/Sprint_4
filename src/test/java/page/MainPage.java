package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class MainPage extends AbstractPage {

    private final By headerLocator = By.className("Home_Header__iJKdX");
    private final By questionsLocator = By.className("accordion");
//    private final By OrderButtonTop = By.className("Button_Button__ra12g"); // Кнопка заказать верхняя
//    private final By nameInputField = By.xpath(".//input[@placeholder='* Имя']"); // Поле ввода имени
//    private final By surnameInputField = By.xpath(".//input[@placeholder='* Фамилия']"); // Поле ввода фамилии
//    private final By adressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // Поле ввода адреса
//    private final By stationBabushkinskaya = By.xpath(".//input[@placeholder='* Станция метро' and @value='Бабушкинская']"); //метро Бабушкинская
//    private final By metroStation = By.className("select-search__input"); // Станция метро
//    private final By phoneNumberForContact = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // Телефон для связи с курьером
//    private final By buttonContinue = By.xpath(".//button[text()='Далее']"); // Кнопка далее
//    private final By dateField = By.className("react-datepicker-ignore-onclickoutside"); //Поле для ввода даты
//    private final By rentalPeriodSelectionField = By.className("Dropdown-placeholder"); // Поле выбора срока аренды
//    private final By rentForADay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']"); //Аренда на сутки
//    private final By rentForATwoDays = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']"); //Аренда на 2 дня
//    private final By rentForAThreeDays = By.xpath(".//div[@class='Dropdown-option' and text()='трое суток']"); //Аренда на 3 дня
//    private final By rentForAFourDays = By.xpath(".//div[@class='Dropdown-option' and text()='четверо суток']"); //Аренда на 4 дня
//    private final By rentForAFiveDays = By.xpath(".//div[@class='Dropdown-option' and text()='пятеро суток']"); //Аренда на 5 дней
//    private final By rentForASixDays = By.xpath(".//div[@class='Dropdown-option' and text()='шестеро суток']"); //Аренда на 6 дней
//    private final By rentForASevenDays = By.xpath(".//div[@class='Dropdown-option is-selected' and text()='семеро суток']"); //Аренда на 7 дней
//    private final By ColorSelectionField = By.className("Order_Title__3EKne"); // Поле выбора цвета самоката
//    private final By colorBlack = By.id("black"); //Выбор черного самоката
//    private final By colorGrey = By.id("grey"); // Выбор серого самоката
//    private final By commentForTheCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']"); //Поле ввода комментария для курьера
//    private final By backButton = By.className("Button_Inverted__3IF-i"); // кнопка Назад в окне про аренду
//    private final By orderButtonInPopup = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"); //кнопка Заказать в окне про аренду
//    private final By doYoyWantToOrder = By.className("Order_ModalHeader__3FDaJ"); //Хотите оформить заказ
//    private final By orderConfirmationButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']"); //Кнопка подтверждения заказа Да
//    private final By cancelOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет']"); // Кнопка отмены заказа Нет
//
//
//
//    private final By OrderStatus = By.className("Header_Link__1TAG7"); // Кнопка Статус заказа
//    private final By orderNumberEntryField = By.className("Input_Input__1iN_Z "); // Поле ввода номера заказа
//    private final By goButton = By.className("Header_Button__28dPO  "); // Кнопка Go
//    private final By OrderButtonDown = By.className("Button_Middle__1CSJM"); // Кнопка заказать нижняя
//    private final By questionAboutPrice = By.id("accordion__heading-8"); // Сколько это стоит? И как оплатить?
//    private final By questionAboutTheAmountOfRent = By.id("accordion__heading-9"); // Хочу сразу несколько самокатов! Так можно?
//    private final By questionAboutTime = By.id("accordion__heading-10"); // Как рассчитывается время аренды?
//    private final By questionAboutOrderingToday = By.id("accordion__heading-11"); // Можно ли заказать самокат прямо на сегодня?
//    private final By extendTheOrderOrReturnEarlier = By.id("accordion__heading-12"); // Можно ли продлить заказ или вернуть самокат раньше?
//    private final By questionAboutCharger = By.id("accordion__heading-13"); // Вы привозите зарядку вместе с самокатом?
//    private final By questionAboutCancelingAnOrder = By.id("accordion__heading-14"); // Можно ли отменить заказ?
//    private final By possibleToDeliverForMKAD = By.id("accordion__heading-15"); // Я живу за МКАДом, привезёте?

    public MainPage(WebDriver driver) {
        super(driver);

        var gotHeaderText = driver.findElement(headerLocator).getText();
        var wantHeaderText = "Самокат\n" +
                "на пару дней\n" +
                "Привезём его прямо к вашей двери,\n" +
                "а когда накатаетесь — заберём";
        assertEquals(wantHeaderText, gotHeaderText);

        driver.findElement(By.xpath(".//button[text()='да все привыкли']")).click();
    }

    public CreateOrderPage toOrder() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        return new CreateOrderPage(driver);
    }

    public CreateOrderPage toOrderBySecondButton() {
        driver.findElement(By.className("Button_Button__ra12g")).click(); // todo change class
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
