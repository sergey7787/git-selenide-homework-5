package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitTest {

    @Test
    void shouldFindGitTest() {
        // открыть страницу github.org
        open("https://github.com/");
        // в поиск ввести selenide и нажать ентер
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажать на первую найденную ссылку
        $$("ul.repo-list li").first().$("a").click();
        // проверить наличие selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        // нажать на WIKI
        $("#wiki-tab").click();
        //убедиться что на странице есть SoftAssertions и переходим в статью
        $(".js-wiki-more-pages-link").click();
        $$("ul.list-style-none.m-0.p-0 li").findBy(text("SoftAssertions")).click();
        //ищем пример кода на JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
