package com.ctu.Library.PhieuTraDetail.DTO;

import com.ctu.Library.Enum.TinhTrang;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class AddPhieuTraDetailDTO {
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
    private Long bookItemId;

}
