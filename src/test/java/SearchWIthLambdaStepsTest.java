import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchWIthLambdaStepsTest {
    @BeforeAll
    static void beforeAll () {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void searchIssueTest () {
        step("Открыть главную страницу", () -> open("https://github.com/"));
        step("Ввести в поле поиска название репозитория и нажать Enter", () -> {
            $(".header-search-input").setValue("IvZl/qa_guru_6").pressEnter();
        });
        step("Кликнуть на название искомого репозитория", () -> $(By.linkText("IvZl/qa_guru_6")).click());
        step("Проверить наличие вкладки Issues в табе", () -> {
            $(".js-sidenav-container-pjax").shouldHave(Condition.text("Issues"));
        });
    }

}
