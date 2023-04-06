package com.ctu.Library.PhieuGHan.DTO;

import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.PhieuGHanDetail.PhieuGHanDetail;
import com.ctu.Library.Reader.Reader;
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
public class PhieuGHanDTO {
    private Date ngayTra;
    private String note = "";
    private Set<PhieuGHanDetail> chitiets;
    private Librarian librarian;
    private Reader reader;
}
