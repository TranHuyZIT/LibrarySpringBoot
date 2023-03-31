package com.ctu.Library.auth;

import com.ctu.Library.User.Gender;
import com.ctu.Library.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class IdentityResponse {
    private Long id;
    private String userName;
    private String email;
    private String name;
    private Role role;
    private String phone;
    private Gender gender;
}
