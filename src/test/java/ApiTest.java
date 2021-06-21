import adapters.ProjectAdapter;
import models.Project;
import models.ProjectFactory;
import models.ResponseProject;
import models.ResponseStatus;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ApiTest {

//    @Test
//    public void projectTest() {
//
//        String response = new ProjectAdapter().create("{}", 200);
//        assertEquals(response,
//                "{\n" +
//                        "    \"status\": false,\n" +
//                        "    \"errorMessage\": \"Data is invalid.\",\n" +
//                        "    \"errorFields\": [\n" +
//                        "        {\n" +
//                        "            \"field\": \"code\",\n" +
//                        "            \"error\": \"Project with the same code already exists.\"\n" +
//                        "        }\n" +
//                        "    ]\n" +
//                        "}");
//        given().
//                header("Token", "833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
//                header("Content-Type", "application/json").
//                body("{}").
//        when().
//                post("https://api.qase.io/v1/project").
//        then().
//                statusCode(200).
//                body("errorMessage", equalTo("Data is invalid"),
//                        "errorFields[0]", equalTo("Title is required"));
//    }

    @Test
    public void projectTest2() {
        Project project = Project.builder()
                .title("TEST3")
                .code("QWERTYUIH")
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void get() {
      //  System.out.println( new ProjectAdapter().get(200, "https://api.qase.io/v1/project").toString());
        ResponseProject project = new ProjectAdapter().getProject("ENTHIR");
        System.out.println(project);
    }

    @Test
    public void createProjectWithProjectCode() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void createProjectWithDescription() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .description(ProjectFactory.get().getDescription())
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void createProjectWithProjectAccessType() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .description(ProjectFactory.get().getDescription())
                .access(ProjectFactory.get().getAccess())
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void createProjectWithMembersAccess() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .description(ProjectFactory.get().getDescription())
                .access(ProjectFactory.get().getAccess())
                .group(ProjectFactory.get().getGroup())
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }
}
