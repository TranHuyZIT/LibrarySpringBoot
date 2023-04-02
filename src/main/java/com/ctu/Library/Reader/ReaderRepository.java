package com.ctu.Library.Reader;

import com.ctu.Library.PhieuMuon.PhieuMuon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Page<Reader> findAll(Pageable pageable);
}
