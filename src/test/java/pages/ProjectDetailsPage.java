package pages;

import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage extends BasePage {

    public boolean isPageOpened() {
        return isExist($(userMenuImage));
    }
}
