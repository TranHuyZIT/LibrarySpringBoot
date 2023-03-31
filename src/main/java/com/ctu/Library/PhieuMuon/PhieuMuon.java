package com.ctu.Library.PhieuMuon;

import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="phieu_muon")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date ngayMuon;
    @Column
    private String note = "";
    @OneToMany
    private Set<PhieuMuonDetail> chitiets;

}
