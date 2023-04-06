package com.ctu.Library.PhieuGHan;

import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.PhieuGHanDetail.PhieuGHanDetail;
import com.ctu.Library.Reader.Reader;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Table(name = "phieu_tra")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PhieuGHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date ngayTra;
    @Column
    private String note = "";
    @OneToMany
    private Set<PhieuGHanDetail> chitiets;

    @OneToMany
    private Librarian librarian;

    @OneToMany
    private Reader reader;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
