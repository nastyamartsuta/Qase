import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.ProjectDetailsPage;
import pages.ProjectListPage;
import pages.ProjectPage;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    protected String user, password;
    protected LoginPage loginPage;
    protected ProjectListPage projectListPage;
    protected ProjectPage projectPage;
    protected ProjectDetailsPage projectDetailsPage;


    @BeforeClass(description = "Open browser")
    public void setUp() {
//        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
//        user = System.getenv().getOrDefault("QASE_USER", PropertyReader.getProperty("qase.user"));
//        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.baseUrl = PropertyReader.getProperty("QASE_URL", "qase.url");
        user = PropertyReader.getProperty("QASE_USER", "qase.user");
        password = PropertyReader.getProperty("QASE_PASSWORD", "qase.password");
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = Boolean.getBoolean(PropertyReader.getProperty("headless"));
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.webdriverLogsEnabled = true;
        loginPage = new LoginPage();
        projectListPage = new ProjectListPage();
        projectPage = new ProjectPage();
        projectDetailsPage = new ProjectDetailsPage();
    }

    @AfterClass(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        getWebDriver().quit();
    }
}
