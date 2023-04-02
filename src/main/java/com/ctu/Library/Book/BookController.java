package com.ctu.Library.Book;

import com.ctu.Library.Book.DTO.AddBookDTO;
import com.ctu.Library.Book.Mapper.AddBookMapper;
import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.DTO.AddBookItemDTO;
import com.ctu.Library.Category.Category;
import com.ctu.Library.config.JsonArg;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public Page<Book> getAllBooks(
            @RequestParam(defaultValue = "0", name="pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", name="pageSize") Integer pageSize,
            @RequestParam(defaultValue = "createdAt", name="sortBy") String sortBy,
            @RequestParam(defaultValue = "true", name="reverse") boolean reverse
    ){return bookService.getAllBooks(pageNo, pageSize, sortBy, reverse);}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBooks(@RequestBody AddBookDTO addBookDTO){
        return bookService.addBook(addBookDTO);
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
