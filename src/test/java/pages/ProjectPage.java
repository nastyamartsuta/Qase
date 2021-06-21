package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectPage extends BasePage {

    public static final SelenideElement PROJECT_NAME_INPUT = $("#inputTitle");
    public static final SelenideElement PROJECT_CODE_INPUT = $("#inputCode");
    public static final SelenideElement DESCRIPTION_INPUT = $("#inputDescription");
    public static final SelenideElement CREATE_PROJECT_BUTTON = $("[type = submit]");
    String inputProjectAccessType = "#private-access-type";
    String inputMembersAccess = "#accessNone";

    public String projectAccessType(String projectAccessType) {
        switch (projectAccessType) {
            case "Private":
                inputProjectAccessType= "#private-access-type";
                break;
            case "Public":
                inputProjectAccessType = "#public-access-type";
                break;
        }
        return inputProjectAccessType;
    }

    public String membersAccess(String membersAccess) {
        switch (membersAccess) {
            case "All":
                inputMembersAccess = "#accessAll";
                break;
            case "Group":
                inputMembersAccess = "#accessGroup";
                break;
            case "None":
                inputMembersAccess = "#accessNone";
                break;
        }
        return inputMembersAccess;
    }

    @Step("Create new Project")
    public ProjectDetailsPage createProject(Project project) {
        String projectAccessType = project.getAccess();
        String membersAccess = project.getGroup();
        $(PROJECT_NAME_INPUT).sendKeys(project.getTitle());
        $(PROJECT_CODE_INPUT).sendKeys(project.getCode());
        $(DESCRIPTION_INPUT).sendKeys(project.getDescription());

        $(projectAccessType(projectAccessType)).click();
        if (!projectAccessType.equals("Public")) {
            $(membersAccess(membersAccess)).click();
        }
        $("[type = submit]").click();
        $("#project-avatar-container").shouldBe(Condition.visible);
        return new ProjectDetailsPage();
    }

    @Override
    public boolean isPageOpened() {
        return isExist(CREATE_PROJECT_BUTTON);
    }
}
