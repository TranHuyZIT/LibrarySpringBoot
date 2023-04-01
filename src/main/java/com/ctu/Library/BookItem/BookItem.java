package com.ctu.Library.BookItem;

import com.ctu.Library.Book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="bookItem")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean trangThai;

    @Column(nullable = false)
    private Integer soLanMuon;

    @Column(nullable = false)
    private String tinhTrang;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;
}
