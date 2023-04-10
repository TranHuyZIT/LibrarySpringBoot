package com.ctu.Library.PhieuGHanDetail.DTO;

import com.ctu.Library.Enum.TinhTrang;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class AddPhieuGHanDetailDTO {
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
    private Date hanTra;
    private Long bookItemId;
}
