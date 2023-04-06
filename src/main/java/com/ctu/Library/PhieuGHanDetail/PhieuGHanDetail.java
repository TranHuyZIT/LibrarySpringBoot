package com.ctu.Library.PhieuGHanDetail;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.Enum.TinhTrang;
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
public class PhieuGHanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
    @Column(nullable = false)
    private Date hanTra;
    @ManyToOne
    private BookItem bookItem;
}
