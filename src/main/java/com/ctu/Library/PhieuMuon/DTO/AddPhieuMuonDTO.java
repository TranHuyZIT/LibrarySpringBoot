package com.ctu.Library.PhieuMuon.DTO;

import com.ctu.Library.PhieuMuonDetail.DTO.PhieuMuonDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AddPhieuMuonDTO {
    Date ngayMuon;
    String note;
    Set<PhieuMuonDetailDTO> chitiets;
}
