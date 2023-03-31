package com.ctu.Library.Book;

import com.ctu.Library.Category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="book")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ten;
    @Column(nullable = false)
    private String namXB;
    @Column(nullable = false)
    private String tacGia;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;
}
