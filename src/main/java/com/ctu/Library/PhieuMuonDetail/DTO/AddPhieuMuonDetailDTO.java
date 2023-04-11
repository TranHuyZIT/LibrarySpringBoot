package com.ctu.Library.PhieuMuonDetail.DTO;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.Enum.TinhTrang;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddPhieuMuonDetailDTO {
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
    private Date hanTra;
    private Long bookItemId;

}
