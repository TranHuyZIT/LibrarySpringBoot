package com.ctu.Library.Book.DTO;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.Category.Category;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String ten;
    private String namXB;
    private String tacGia;
    private Category categoryId;
    private Set<BookItem> listBookItem;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
