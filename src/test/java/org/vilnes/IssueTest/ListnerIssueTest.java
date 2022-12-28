package org.vilnes.IssueTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class ListnerIssueTest extends TestBase {
    private static final String GITHUB_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#81";
    @Test
    @DisplayName("Проверка наличия Issue с наименованием {issue}")
    @Feature("Отображение номера Issues")
    @Story("Проверка наличия Issue с наименованием {issue}")
    @Owner("Dmitry Rodichev")
    @Severity(SeverityLevel.NORMAL)
    void testIssue() {

        step("Открываем главную страницу" + GITHUB_URL, () ->
                open(GITHUB_URL));

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером" + ISSUE_NUMBER, () -> {
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    }
        @Test
        @DisplayName("Проверка наличия Issue с наименованием {issue}")
        @Feature("Отображение номера Issues")
        @Story("Проверка наличия Issue с наименованием {issue}")
        @Owner("Dmitry Rodichev")
        @Severity(SeverityLevel.NORMAL)
        public void stepTestIssue() {
            StepTestIssue stepTestIssue = new StepTestIssue();

            stepTestIssue.openStartPage(GITHUB_URL);
            stepTestIssue.searchRepo(REPOSITORY);
            stepTestIssue.openRepo(REPOSITORY);
            stepTestIssue.openIssueTab();
            stepTestIssue.checkIssueByName(ISSUE_NUMBER);

        }
    }

