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
@Table(name = "phieu_ghan")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PhieuGHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date ngayGHan;
    @Column
    private String note = "";
    @OneToMany
    private Set<PhieuGHanDetail> chitiets;

    @ManyToOne
    private Librarian librarian;

    @ManyToOne
    private Reader reader;
    @Column
    private boolean isChecked = false;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

}
