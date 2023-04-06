package com.ctu.Library.PhieuGHan.Mapper;

import com.ctu.Library.Librarian.LibrarianRepository;
import com.ctu.Library.PhieuGHan.DTO.AddPhieuTraDTO;
import com.ctu.Library.PhieuGHan.PhieuTra;
import com.ctu.Library.PhieuGHanDetail.DTO.PhieuGHanDetailDTO;
import com.ctu.Library.PhieuGHanDetail.Mapper.PhieuTraDetailMapper;
import com.ctu.Library.PhieuGHanDetail.PhieuGHanDetail;
import com.ctu.Library.PhieuGHanDetail.PhieuTraDetailRepository;
import com.ctu.Library.Reader.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AddPhieuTraMapper {
     private final PhieuTraDetailMapper phieuTraDetailMapper;
     private final PhieuTraDetailRepository phieuTraDetailRepository;
     private final LibrarianRepository librarianRepository;
     private final ReaderRepository readerRepository;
     public PhieuTra dtoToModel(AddPhieuTraDTO addPhieuTraDTO) {
          if(addPhieuTraDTO == null)
               return null;

          PhieuTra.PhieuTraBuilder phieuTra = PhieuTra.builder();
          phieuTra.ngayTra(addPhieuTraDTO.getNgayTra());
          phieuTra.note(addPhieuTraDTO.getNote());
          Set<PhieuGHanDetail> chitiets = new HashSet<>();
          for(PhieuGHanDetailDTO chitiet: addPhieuTraDTO.getChitiets()) {
               PhieuGHanDetail newDetail = phieuTraDetailRepository.save(
                      phieuTraDetailMapper.dtoToModel(chitiet)
               );
               chitiets.add(
                       newDetail
               );
          }
     };

}
