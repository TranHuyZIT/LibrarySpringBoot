package com.ctu.Library.BookItem.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AddBookItemDTO {
    private Boolean trangThai;
    private Integer soLanMuon;
    private String tinhTrang;
    private Long book;
}
