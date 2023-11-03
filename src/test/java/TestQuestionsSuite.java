import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import page.MainPage;

public class TestQuestionsSuite extends AbstractTestSuite {
    @DisplayName("Test question has correct answer")
    @ParameterizedTest
    @CsvFileSource(resources = "questions.csv", numLinesToSkip = 1)
    public void dropdownListPageCheck(String question, String answer) {
        var mainPage = new MainPage(driver);
        mainPage.scrollToQuestions();

        var gotAnswer = mainPage.getAnswerForQuestion(question);
        Assertions.assertEquals(answer, gotAnswer);
    }
}
