package com.ctu.Library.Book;

import com.ctu.Library.Category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);
  Page<Book> findAllByTenContaining(String name, Pageable pageable);
  @Query("SELECT b from Book AS b " +
    "WHERE (:name = '' or LOWER(b.ten) like CONCAT('%',:name,'%')) AND " +
    "(b.category.id IN :categories)")
  Page<Book> findAllByFilters(@Param("name") String name, @Param("categories") List<Long> categories, Pageable pageable);
}
