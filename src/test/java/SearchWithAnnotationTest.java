import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchWithAnnotationTest {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ввести в поле поиска название репозитория и нажать Enter")
    public void searchRepository() {
        $(".header-search-input").setValue("IvZl/qa_guru_6").pressEnter();
    }

    @Step("Кликнуть на название искомого репозитория")
    public void openRepository() {
        $(By.linkText("IvZl/qa_guru_6")).click();
    }

    @Step("Проверить наличие вкладки Issues в табе")
    public void searchIssuesTab() {
        $(".js-sidenav-container-pjax").shouldHave(Condition.text("Issues"));
    }

    @Test
    public void annotatedStepsTest() {
        SearchWithAnnotationTest annotatedStepsTest = new SearchWithAnnotationTest();
        annotatedStepsTest.openMainPage();
        annotatedStepsTest.searchRepository();
        annotatedStepsTest.openRepository();
        annotatedStepsTest.searchIssuesTab();
    }
}
