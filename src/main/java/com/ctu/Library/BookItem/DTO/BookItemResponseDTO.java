package com.ctu.Library.BookItem.DTO;

import com.ctu.Library.Book.Book;
import com.ctu.Library.Enum.TinhTrang;
import com.ctu.Library.Reader.Reader;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookItemResponseDTO {
    private Long id;
    private Boolean trangThai;
    private Integer soLanMuon;
    private TinhTrang tinhTrang;
    private Reader reader;
    private Date hanTra;
    private Book book;
}
