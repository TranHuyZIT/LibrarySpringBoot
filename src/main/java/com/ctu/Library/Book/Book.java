package com.ctu.Library.Book;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.Category.Category;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="book")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = "listBookItem")
@ToString(exclude = "listBookItem")
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
    private Category category;

    @OneToMany
    @JsonIgnore
    private Set<BookItem> listBookItem = new HashSet<>();

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public void addBookItem(BookItem bookItem){
        this.listBookItem.add(bookItem);
    }

    public void deleteBookItem(BookItem bookItem){
        this.listBookItem.remove(bookItem);
    }


}
