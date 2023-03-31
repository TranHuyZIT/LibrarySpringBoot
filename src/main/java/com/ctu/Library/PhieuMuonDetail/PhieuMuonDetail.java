package com.ctu.Library.PhieuMuonDetail;

import com.ctu.Library.Enum.TinhTrang;
import com.ctu.Library.PhieuMuon.PhieuMuon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PhieuMuonDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
    @Column(nullable = false)
    private Date hanTra;

}
