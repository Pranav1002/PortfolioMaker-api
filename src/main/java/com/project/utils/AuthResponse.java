package com.project.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {

    private String accessToken;

    private String refreshToken;

    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
    private String about;
    private String gender;
    private String githubProfile;
    private String linkedInProfile;

}