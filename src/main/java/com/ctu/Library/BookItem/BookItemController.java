package com.ctu.Library.BookItem;

import com.ctu.Library.Book.DTO.AddBookDTO;
import com.ctu.Library.BookItem.DTO.AddBookItemDTO;
import com.ctu.Library.BookItem.DTO.BookItemResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/bookItem")
@RequiredArgsConstructor
@RestController
public class BookItemController {
    private final BookItemService bookItemService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookItemResponseDTO> getAllBookItems(){return bookItemService.getAllBookItems();}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookItem addBookItems(@RequestBody AddBookItemDTO bookItem){
        return bookItemService.addBookItems(bookItem);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookItem updateBookItems(@PathVariable Long id, @RequestBody AddBookItemDTO updateBookItem){
        return bookItemService.updateBookItem(id, updateBookItem);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookItem deleteBookItems(@PathVariable Long id){return bookItemService.deleteBookItem(id);}
    @GetMapping("/reader/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookItemResponseDTO> getAllBorrowed(@PathVariable Long id){
      return bookItemService.getAllBookItems(id);
    }
}
