package com.ctu.Library.Reader.DTO;

import com.ctu.Library.User.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;


@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ReaderDTO {
    private Long id;
    private String name;
    private Date birth;
    private String address;
    private String phone;
    private String email;
    private User user;
    Timestamp createdAt;
    Timestamp updatedAt;
}
