package com.ctu.Library.PhieuGHan.DTO;

import com.ctu.Library.PhieuGHanDetail.DTO.AddPhieuGHanDetailDTO;
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
    Date ngayGHan;
    String note = "";
    Set<AddPhieuGHanDetailDTO> chitiets;
    Long librarianId;
    Long readerId;
    boolean isChecked = false;
}
