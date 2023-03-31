package com.ctu.Library.Book.Mapper;

import com.ctu.Library.Book.Book;
import com.ctu.Library.Book.DTO.AddBookDTO;
import com.ctu.Library.Book.DTO.BookDTO;
import com.ctu.Library.Category.Category;
import com.ctu.Library.Category.CategoryRepository;
import com.ctu.Library.Category.CategoryService;
import com.ctu.Library.ExceptionHandling.CustomException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddBookMapper {
    private final CategoryRepository categoryRepository;
    public Book dtoToModel(AddBookDTO addBookDTO){
        if (addBookDTO == null){
            return null;
        }
        Book.BookBuilder book = Book.builder();
//        book.id(addBookDTO.getId() );
        book.ten(addBookDTO.getTen() );
        book.namXB(addBookDTO.getNamXB() );
        book.tacGia(addBookDTO.getTacGia() );
        Category category = categoryRepository.findById(
                addBookDTO.getCategoryId()
        ).orElseThrow(()-> new CustomException("Không tìm thấy danh mục với mã thể loại" + addBookDTO.getCategoryId(), HttpStatus.NOT_FOUND));
        book.categoryId(category);
        return book.build();
    }

}
