package com.ctu.Library.BookItem.Mapper;

import com.ctu.Library.Book.Book;
import com.ctu.Library.Book.BookRepository;
import com.ctu.Library.Book.DTO.AddBookDTO;
import com.ctu.Library.Book.Mapper.AddBookMapper;
import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.DTO.AddBookItemDTO;
import com.ctu.Library.ExceptionHandling.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class AddBookItemMapper {
    private final BookRepository bookRepository;

    public BookItem dtoToModel(AddBookItemDTO addBookItemDTO){
        if(addBookItemDTO == null){
            return null;
        }
        BookItem.BookItemBuilder bookItem = BookItem.builder();
        bookItem.trangThai(addBookItemDTO.getTrangThai() );
        bookItem.soLanMuon(addBookItemDTO.getSoLanMuon() );
        bookItem.tinhTrang(addBookItemDTO.getTinhTrang() );
        return bookItem.build();
    }
}
