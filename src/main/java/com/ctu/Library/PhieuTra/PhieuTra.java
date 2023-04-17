package com.ctu.Library.PhieuTra;

import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.PhieuTraDetail.PhieuTraDetail;
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
@Table(name="phieu-tra")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PhieuTra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date ngayTra;
    @Column
    private String note = "";
    @OneToMany
    private Set<PhieuTraDetail> chitiets;
    @Column
    private boolean isChecked = false;

    @ManyToOne
    private Librarian librarian;

    @ManyToOne
    private Reader reader;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp createdAt;

    @UpdateTimestamp
    @Column
    Timestamp updatedAt;

}
