package com.ctu.Library.BookItem.DTO;

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
public class AddBookItemDTO {
    private Boolean trangThai;
    private Integer soLanMuon;
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
}
