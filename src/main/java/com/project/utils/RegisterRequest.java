package com.project.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String about;
    private String gender;
    private String githubProfile;
    private String linkedInProfile;
}
