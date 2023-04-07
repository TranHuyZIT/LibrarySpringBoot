package com.ctu.Library.PhieuGHanDetail.DTO;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.Enum.TinhTrang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PhieuGHanDetailDTO {
    private TinhTrang tinhTrang;
    private Date hanTra;
    private BookItem bookItem;
}
