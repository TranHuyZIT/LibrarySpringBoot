package com.ctu.Library.auth;

import com.ctu.Library.User.Gender;
import com.ctu.Library.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegisterRequest {
    private String name;
    private String userName;
    private String password;
    private String email;
    private Role role;
    private Gender gender;
    private  String phone;
}
