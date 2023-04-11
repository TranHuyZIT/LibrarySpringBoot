package com.ctu.Library.Librarian;

import com.ctu.Library.PhieuMuon.PhieuMuon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    Page<Librarian> findAll(Pageable pageable);
    Librarian findOneByUser_Id(Long userId);
}
