package com.ctu.Library.Book;

import com.ctu.Library.Book.DTO.AddBookDTO;
import com.ctu.Library.Book.Mapper.AddBookMapper;
import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.BookItemRepository;
import com.ctu.Library.BookItem.BookItemService;
import com.ctu.Library.BookItem.DTO.AddBookItemDTO;
import com.ctu.Library.BookItem.Mapper.AddBookItemMapper;
import com.ctu.Library.Category.Category;
import com.ctu.Library.Category.CategoryService;
import com.ctu.Library.ExceptionHandling.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AddBookMapper addBookMapper;
    private final CategoryService categoryService;
    private final BookItemRepository bookItemRepository;
    @Lazy
    @Autowired
    private BookItemService bookItemService;
    private final AddBookItemMapper addBookItemMapper;

    public Book findById(long id) {return bookRepository.findById(id).orElseThrow(()->new CustomException("Không tìm thấy loại sản phẩm với mã " + id, HttpStatus.NOT_FOUND));}

    public Page<Book> getAllBooks(List<Long> categoryIds,String name, Integer pageNo, Integer pageSize, String sortBy, Boolean reverse){
        Pageable pageable;
        if (pageNo == -1){
             pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(reverse? Sort.Direction.DESC : Sort.Direction. ASC, sortBy));
              if (!Objects.equals(name, "") || !categoryIds.isEmpty()){
                if (categoryIds.isEmpty()){
                  return  bookRepository.findAllByTenContaining(name, pageable);
                }
                return bookRepository.findAllByFilters(name, categoryIds, pageable);
              }
              return bookRepository.findAll(pageable);
        }
        pageable = PageRequest.of(pageNo, pageSize, Sort.by(reverse ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));

        if (!Objects.equals(name, "") || !categoryIds.isEmpty()){
          if (categoryIds.isEmpty()){
            return  bookRepository.findAllByTenContaining(name, pageable);
          }
          return bookRepository.findAllByFilters(name, categoryIds, pageable);
        }
        return bookRepository.findAll(pageable);
    }


    public Book addBook(AddBookDTO addBookDTO){
        System.out.println(addBookDTO.getListBookItem());
        Book book =  addBookMapper.dtoToModel(addBookDTO);
        book.setListBookItem(new ArrayList<>());
        Book saved = bookRepository.save(book);
        List<BookItem> bookItemSet = new ArrayList<>();
        for (AddBookItemDTO addBookItemDTO: addBookDTO.getListBookItem()){
            addBookItemDTO.setBookId(saved.getId());
            BookItem bookItem = bookItemService.addBookItems(addBookItemDTO);
            bookItemSet.add(bookItem);
        }
        book.setListBookItem(bookItemSet);
        System.out.println(book);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id,AddBookDTO newBookDTO){
        Book currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        currentBook.setTen(newBookDTO.getTen());
        currentBook.setNamXB(newBookDTO.getNamXB());
        currentBook.setTacGia(newBookDTO.getTacGia());
        Category category = categoryService.findById(newBookDTO.getCategoryId());
        currentBook.setCategory(category);

        List<BookItem> bookItemSet = new ArrayList<>();
        for (AddBookItemDTO addBookItemDTO: newBookDTO.getListBookItem()){
          bookItemSet.add(bookItemService.addBookItems(addBookItemDTO));
        }
        currentBook.setListBookItem(bookItemSet);

        return bookRepository.save(currentBook);
    }
    public Book findOne(Long id){
      return bookRepository.findById(id).orElseThrow(
        () -> new CustomException("Không tồn tại sách với mã " + id, HttpStatus.NOT_FOUND)
      );
    }

    public Book deleteBook(Long id){
        Book currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        bookItemService.deleteByBookId(currentBook.getId());
        bookRepository.delete(currentBook);
        return currentBook;
    }
    public Book addBookItem(Long id, AddBookItemDTO addBookItemDTO){
        Book currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        currentBook.addBookItem(bookItemService.addBookItems(addBookItemDTO));
        return bookRepository.save(currentBook);
    }
}
