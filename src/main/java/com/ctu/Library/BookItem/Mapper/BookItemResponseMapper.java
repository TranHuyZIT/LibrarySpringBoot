package com.ctu.Library.BookItem.Mapper;

import com.ctu.Library.Book.Book;
import com.ctu.Library.Book.BookRepository;
import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.DTO.BookItemResponseDTO;
import com.ctu.Library.ExceptionHandling.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookItemResponseMapper {
    private final BookRepository bookRepository;
    public BookItemResponseDTO modeltoDTO(BookItem bookItem){
        Book book = bookRepository.findById(bookItem.getBookId()).orElseThrow(
                () -> new CustomException("Không tìm thấy sách với mã" + bookItem.getBookId(), HttpStatus.NOT_FOUND)
        );
        return BookItemResponseDTO.builder()
                .id(bookItem.getId())
                .trangThai(bookItem.getTrangThai())
                .tinhTrang(bookItem.getTinhTrang())
                .soLanMuon(bookItem.getSoLanMuon())
                .reader(bookItem.getReader())
                .hanTra(bookItem.getHanTra())
                .book(book)
                .build();
    }
}
