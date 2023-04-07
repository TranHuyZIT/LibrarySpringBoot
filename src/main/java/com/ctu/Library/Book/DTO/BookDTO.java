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
import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String ten;
    private String mota;
    private String image;
    private Date namXB;
    private String tacGia;
    private Category category;
    private List<BookItem> listBookItem;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
