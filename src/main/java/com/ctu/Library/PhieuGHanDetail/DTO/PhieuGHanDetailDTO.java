package com.ctu.Library.PhieuTraDetail.DTO;

import com.ctu.Library.Enum.TinhTrang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PhieuTraDetailDTO {
    private TinhTrang tinhTrang;
}
