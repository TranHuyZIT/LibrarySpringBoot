package com.ctu.Library.PhieuGHan.DTO;

import com.ctu.Library.PhieuGHanDetail.DTO.PhieuGHanDetailDTO;
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
public class AddPhieuGHanDTO {
    Date ngayTra;
    String note = "";
    Set<PhieuGHanDetailDTO> chitiets;
    Long librarian;
    Long reader;
}
