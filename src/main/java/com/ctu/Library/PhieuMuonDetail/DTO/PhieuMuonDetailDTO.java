package com.ctu.Library.PhieuMuonDetail.DTO;

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
public class PhieuMuonDetailDTO {
    private TinhTrang tinhTrang;
    private Date hanTra;
}
