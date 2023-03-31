package com.ctu.Library.Book;

import com.ctu.Library.Book.DTO.AddBookDTO;
import com.ctu.Library.Book.Mapper.AddBookMapper;
import com.ctu.Library.Category.Category;
import com.ctu.Library.Category.CategoryService;
import com.ctu.Library.ExceptionHandling.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AddBookMapper addBookMapper;
    private final CategoryService categoryService;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(AddBookDTO addBookDTO){
        Book book =  addBookMapper.dtoToModel(addBookDTO);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id,AddBookDTO newBookDTO){
        Book currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        currentBook.setTen(newBookDTO.getTen());
        currentBook.setNamXB(newBookDTO.getNamXB());
        currentBook.setTacGia(newBookDTO.getTacGia());
        Category category = categoryService.findById(newBookDTO.getCategoryId());
        currentBook.setCategoryId(category);
        return bookRepository.save(currentBook);
    }

    public Book deleteBook(Long id){
        Book currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        bookRepository.deleteById(id);
        return currentBook;
    }
}
