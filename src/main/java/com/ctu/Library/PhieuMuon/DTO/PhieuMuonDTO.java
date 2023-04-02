package com.ctu.Library.PhieuMuon.DTO;

import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
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
public class PhieuMuonDTO {
    private Date ngayMuon;
    private String note = "";
    private Librarian librarian;
    private Reader reader;
    private Set<PhieuMuonDetail> chitiets;
}
