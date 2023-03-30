package com.ctu.Library.Librarian;

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
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date dob;
    @Column(nullable = false)
    private String contact;
}
