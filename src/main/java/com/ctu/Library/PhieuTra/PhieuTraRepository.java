package com.ctu.Library.PhieuTra;

import com.ctu.Library.PhieuMuon.PhieuMuon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuTraRepository extends JpaRepository<PhieuTra, Long> {
    Page<PhieuTra> findAll(Pageable pageable);
    Page<PhieuTra> findAllByReaderId(Long readerId, Pageable pageable);
}
