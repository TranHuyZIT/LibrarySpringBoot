package com.ctu.Library.Category;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

}
