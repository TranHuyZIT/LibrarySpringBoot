package com.ctu.Library.Librarian;

import com.ctu.Library.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Librarian")
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Date dob;
    @Column
    private String contact;
    @OneToOne
    @JoinColumn(name = "user-id", referencedColumnName = "id")
    private User user;
    @Column
    boolean hasUpdateInfo = false;
}
