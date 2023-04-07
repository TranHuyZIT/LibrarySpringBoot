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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Book> getAllBooks(
            @RequestParam(defaultValue = "", name = "categoryIds") String categoryIds,
            @RequestParam(defaultValue = "", name = "name") String name,
            @RequestParam(defaultValue = "0", name="pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", name="pageSize") Integer pageSize,
            @RequestParam(defaultValue = "createdAt", name="sortBy") String sortBy,
            @RequestParam(defaultValue = "true", name="reverse") boolean reverse
    ){
      List<Long> categoryLongs = new ArrayList<>();
      if (!Objects.equals(categoryIds, "")){
        System.out.println("Down here");
        System.out.println(categoryIds);
        categoryLongs = Arrays.stream(categoryIds.split(",")).map(Long::parseLong).toList();
      }
      return bookService.getAllBooks(categoryLongs, name, pageNo - 1, pageSize, sortBy, reverse);
    }

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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book findOne(@PathVariable Long id){
      return bookService.findOne(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }


}
