package com.ctu.Library.PhieuMuon;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuMuonRepository extends JpaRepository<PhieuMuon, Long> {
    Page<PhieuMuon> findAll(Pageable pageable);
    Page<PhieuMuon> findAllByReaderId(Long readerId, Pageable pageable);
}
