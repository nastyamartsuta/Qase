package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    public static final SelenideElement EMAIL_INPUT = $("#inputEmail");
    public static final SelenideElement PASSWORD_INPUT = $("#inputPassword");
    public static final SelenideElement LOGIN_BUTTON = $("#btnLogin");

    @Step("Open Login page")
    public LoginPage openPage() {
        open("/login");
        return this;
    }

    @Step("Click button Login")
    public boolean isPageOpened() {
        return isExist(LOGIN_BUTTON);
    }

    public ProjectListPage login(String user, String password) {
        $(EMAIL_INPUT).sendKeys(user);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return new ProjectListPage();
    }
}
