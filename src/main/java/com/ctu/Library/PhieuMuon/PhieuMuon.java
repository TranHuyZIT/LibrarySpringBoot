package com.ctu.Library.PhieuMuon;

import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import com.ctu.Library.Reader.Reader;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
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

    @ManyToOne
    private Librarian librarian;

    @ManyToOne
    private Reader reader;
    @Column
    private boolean isChecked = false;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp createdAt;

    @UpdateTimestamp
    @Column
    Timestamp updatedAt;

}
