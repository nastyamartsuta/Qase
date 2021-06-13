package models;

import com.github.javafaker.Faker;

public class ProjectFactory {
    public static Project get() {
        Faker faker = new Faker();
        return Project.builder()
                .projectName(faker.company().name())
                .projectCode(faker.code().isbn10())
                .description("Create new project")
                .projectAccessType("Private")
                .membersAccess("Don't add members")
                .build();
    }
}
