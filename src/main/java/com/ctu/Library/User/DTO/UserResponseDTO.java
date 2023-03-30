package com.ctu.Library.User.DTO;

import com.ctu.Library.User.Gender;
import com.ctu.Library.User.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String name;
    private String userName;
    private  String email;
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String token = "";
}
