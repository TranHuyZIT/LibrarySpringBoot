package com.ctu.Library.PhieuMuonDetail.DTO;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.Enum.TinhTrang;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class AddPhieuMuonDetailDTO {
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
    private Date hanTra;
    private Long bookItemId;

}
