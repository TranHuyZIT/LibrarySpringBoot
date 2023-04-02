package com.ctu.Library.BookItem.DTO;

import com.ctu.Library.Book.Book;
import com.ctu.Library.Enum.TinhTrang;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
}
