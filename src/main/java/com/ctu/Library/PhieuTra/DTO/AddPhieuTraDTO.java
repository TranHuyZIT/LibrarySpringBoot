package com.ctu.Library.PhieuTra.DTO;

import com.ctu.Library.PhieuTraDetail.DTO.AddPhieuTraDetailDTO;
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
public class AddPhieuTraDTO {
    Date ngayTra;
    String note;
    Set<AddPhieuTraDetailDTO> chitiets;
    Long readerId;
    Long librarianId;
    boolean isChecked;
}
