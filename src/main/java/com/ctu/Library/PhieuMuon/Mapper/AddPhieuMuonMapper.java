package com.ctu.Library.PhieuMuon.Mapper;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.Librarian.LibrarianRepository;
import com.ctu.Library.PhieuMuon.DTO.AddPhieuMuonDTO;
import com.ctu.Library.PhieuMuon.PhieuMuon;
import com.ctu.Library.PhieuMuonDetail.DTO.AddPhieuMuonDetailDTO;
import com.ctu.Library.PhieuMuonDetail.DTO.PhieuMuonDetailDTO;
import com.ctu.Library.PhieuMuonDetail.Mapper.AddPhieuMuonDetailMapper;
import com.ctu.Library.PhieuMuonDetail.Mapper.PhieuMuonDetailMapper;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetailRepository;
import com.ctu.Library.Reader.Reader;
import com.ctu.Library.Reader.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AddPhieuMuonMapper {
    private final PhieuMuonDetailMapper phieuMuonDetailMapper;
    private final AddPhieuMuonDetailMapper addPhieuMuonDetailMapper;
    private final ReaderRepository readerRepository;
    private final LibrarianRepository librarianRepository;
    private final PhieuMuonDetailRepository phieuMuonDetailRepository;
    public PhieuMuon dtoToModel(AddPhieuMuonDTO addPhieuMuonDTO){
        if (addPhieuMuonDTO == null){
            return null;
        }
        PhieuMuon.PhieuMuonBuilder phieuMuon = PhieuMuon.builder();
        phieuMuon.ngayMuon(addPhieuMuonDTO.getNgayMuon());
        phieuMuon.note(addPhieuMuonDTO.getNote());
        Set<PhieuMuonDetail> chitiets = new HashSet<>();
        for(AddPhieuMuonDetailDTO chitiet: addPhieuMuonDTO.getChitiets()){
            PhieuMuonDetail newDetail = phieuMuonDetailRepository.save(
                    addPhieuMuonDetailMapper.dtoToModel(chitiet)
            );
            chitiets.add(
                    newDetail
            );
        }
        Reader reader = readerRepository.findById(addPhieuMuonDTO.getReaderId()).orElseThrow(()
                -> new CustomException("Không tồn tại độc giả với mã " + addPhieuMuonDTO.getReaderId(), HttpStatus.NOT_FOUND));
        Librarian librarian = librarianRepository.findById(addPhieuMuonDTO.getLibrarianId()).orElseThrow(
                () -> new CustomException("Không tồn tại thủ thư với mã " + addPhieuMuonDTO.getLibrarianId(), HttpStatus.NOT_FOUND)
        );
        phieuMuon.reader(reader);
        phieuMuon.librarian(librarian);
        phieuMuon.chitiets(chitiets);
        return phieuMuon.build();
    }
}
