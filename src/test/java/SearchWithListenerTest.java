import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchWithListenerTest {
    @BeforeAll
    static void beforeAll () {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void searchIssueTest () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(".header-search-input").setValue("IvZl/qa_guru_6").pressEnter();
        $(By.linkText("IvZl/qa_guru_6")).click();
        $(".js-sidenav-container-pjax").shouldHave(Condition.text("Issues"));
    }

}
