import models.Project;
import models.ProjectFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void createProject() {

        loginPage
                .openPage()
                .login(user, password)
                .clickButtonCreateNewProject();

        Project project = ProjectFactory.get();
        projectPage
                .createProject(project)
                .isPageOpened();
        projectListPage
                .openProjectPage()
                .validateProject(project);
    }
}
