package com.ctu.Library.BookItem;


import com.ctu.Library.Book.Book;
import com.ctu.Library.Book.BookRepository;
import com.ctu.Library.Book.BookService;
import com.ctu.Library.BookItem.DTO.AddBookItemDTO;
import com.ctu.Library.BookItem.Mapper.AddBookItemMapper;
import com.ctu.Library.ExceptionHandling.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookItemService {
    private final BookItemRepository bookItemRepository;
    private final AddBookItemMapper addBookItemMapper;
    private final BookService bookService;
    private final BookRepository bookRepository;
    public List<BookItem> getAllBookItems(Long readerId){
        return bookItemRepository.findByReaderId(readerId);
    }
    public List<BookItem> getAllBookItems(){
      return bookItemRepository.findAll();
  }
    public void deleteByBookId(Long bookId){
        bookItemRepository.deleteAll(getAllBookItems());
    }
    public BookItem addBookItems(AddBookItemDTO addBookItemDTO){
        BookItem bookItem = addBookItemMapper.dtoToModel(addBookItemDTO);
        return bookItemRepository.save(bookItem);
    }

    public BookItem updateBookItem(Long id, AddBookItemDTO newBookItemDTO){
        BookItem currentBookItem = bookItemRepository.findById(id)
                .orElseThrow(()-> new CustomException("Không tìm thấy danh mục với mã:" + id, HttpStatus.NOT_FOUND));
        currentBookItem.setTrangThai(newBookItemDTO.getTrangThai() );
        currentBookItem.setSoLanMuon(newBookItemDTO.getSoLanMuon() );
        currentBookItem.setTinhTrang(newBookItemDTO.getTinhTrang()) ;;
        return bookItemRepository.save(currentBookItem);
    }

    public BookItem deleteBookItem(Long id){
        BookItem currentBookItem = bookItemRepository.findById(id)
                .orElseThrow(()-> new CustomException("Không tìm thấy danh mục với mã:" + id, HttpStatus.NOT_FOUND));
        bookItemRepository.deleteById(id);
        return currentBookItem;
    }
}
