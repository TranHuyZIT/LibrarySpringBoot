package com.ctu.Library.Librarian.DTO;

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
public class LibrarianDTO {
    private Long id;
    private String name;
    private Date dob;
    private String contact;
    private User user;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
