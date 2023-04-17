package com.ctu.Library.PhieuTra.Mapper;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.Librarian.LibrarianRepository;
import com.ctu.Library.PhieuTra.DTO.AddPhieuTraDTO;
import com.ctu.Library.PhieuTra.PhieuTra;
import com.ctu.Library.PhieuTraDetail.DTO.AddPhieuTraDetailDTO;
import com.ctu.Library.PhieuTraDetail.Mapper.AddPhieuTraDetailMapper;
import com.ctu.Library.PhieuTraDetail.Mapper.PhieuTraDetailMapper;
import com.ctu.Library.PhieuTraDetail.PhieuTraDetail;
import com.ctu.Library.PhieuTraDetail.PhieuTraDetailRepository;
import com.ctu.Library.Reader.Reader;
import com.ctu.Library.Reader.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AddPhieuTraMapper {
    private final PhieuTraDetailMapper phieuMuonDetailMapper;
    private final AddPhieuTraDetailMapper addPhieuTraDetailMapper;
    private final ReaderRepository readerRepository;
    private final LibrarianRepository librarianRepository;
    private final PhieuTraDetailRepository phieuTraDetailRepository;
    public PhieuTra dtoToModel(AddPhieuTraDTO addPhieuTraDTO){
        if (addPhieuTraDTO == null){
            return null;
        }
        PhieuTra.PhieuTraBuilder phieuTra = PhieuTra.builder();
        phieuTra.ngayTra(addPhieuTraDTO.getNgayTra());
        phieuTra.note(addPhieuTraDTO.getNote());
        phieuTra.isChecked(addPhieuTraDTO.isChecked());
        Set<PhieuTraDetail> chitiets = new HashSet<>();
        for(AddPhieuTraDetailDTO chitiet: addPhieuTraDTO.getChitiets()){
            PhieuTraDetail newDetail = phieuTraDetailRepository.save(
                    addPhieuTraDetailMapper.dtoToModel(chitiet)
            );
            chitiets.add(
                    newDetail
            );
        }
        Reader reader = readerRepository.findById(addPhieuTraDTO.getReaderId()).orElseThrow(()
                -> new CustomException("Không tồn tại độc giả với mã " + addPhieuTraDTO.getReaderId(), HttpStatus.NOT_FOUND));
        Librarian librarian = librarianRepository.findById(addPhieuTraDTO.getLibrarianId()).orElseThrow(
                () -> new CustomException("Không tồn tại thủ thư với mã " + addPhieuTraDTO.getLibrarianId(), HttpStatus.NOT_FOUND)
        );
        phieuTra.reader(reader);
        phieuTra.librarian(librarian);
        phieuTra.chitiets(chitiets);
        return phieuTra.build();
    }
}
