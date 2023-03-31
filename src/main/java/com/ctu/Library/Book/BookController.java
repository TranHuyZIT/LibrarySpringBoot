package com.ctu.Library.Book;

import com.ctu.Library.Book.DTO.AddBookDTO;
import com.ctu.Library.Book.Mapper.AddBookMapper;
import com.ctu.Library.Category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){return bookService.getAllBooks();};

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBooks(@RequestBody AddBookDTO book){
        return bookService.addBook(book);
    };

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBooks(@PathVariable Long id, @RequestBody AddBookDTO updateBook){
        return bookService.updateBook(id, updateBook);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
}
