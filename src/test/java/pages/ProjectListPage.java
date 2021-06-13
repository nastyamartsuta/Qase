package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class ProjectListPage extends BasePage {

    public static final SelenideElement CREATE_NEW_PROJECT_BUTTON = $("#createButton");
    public static final SelenideElement SEARCH_INPUT = $("[name='title']");

    String locatorProjectName = "//*[text()='%s']";

    @Step("Open Project page")
    public ProjectListPage openProjectPage() {
        open("/projects");
        return this;
    }

    @Step("Click button create new project")
    public void clickButtonCreateNewProject() {
        $(CREATE_NEW_PROJECT_BUTTON).click();
    }

    public void validateProject(Project project) {
        SEARCH_INPUT.setValue(project.getProjectName());
        $(byXpath(String.format(locatorProjectName, project.getProjectName()))).shouldBe(Condition.visible);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(CREATE_NEW_PROJECT_BUTTON);
    }
}
