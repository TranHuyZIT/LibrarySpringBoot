package com.ctu.Library.BookItem.DTO;

import com.ctu.Library.Book.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BookItemDTO {
    private Long id;
    private Boolean trangThai;
    private Integer soLanMuon;
    private String tinhTrang;
    private Book book;
}
