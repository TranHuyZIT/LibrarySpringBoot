package com.ctu.Library.PhieuGHan.Mapper;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.Librarian.LibrarianRepository;
import com.ctu.Library.PhieuGHan.DTO.AddPhieuGHanDTO;
import com.ctu.Library.PhieuGHan.PhieuGHan;
import com.ctu.Library.PhieuGHanDetail.DTO.AddPhieuGHanDetailDTO;
import com.ctu.Library.PhieuGHanDetail.Mapper.AddPhieuGHanDetailMapper;
import com.ctu.Library.PhieuGHanDetail.PhieuGHanDetail;
import com.ctu.Library.PhieuGHanDetail.PhieuGHanDetailRepository;
import com.ctu.Library.Reader.Reader;
import com.ctu.Library.Reader.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AddPhieuGHanMapper {
     private final AddPhieuGHanDetailMapper addPhieuGHanDetailMapper;
     private final PhieuGHanDetailRepository phieuGHanDetailRepository;
     private final LibrarianRepository librarianRepository;
     private final ReaderRepository readerRepository;
     public PhieuGHan dtoToModel(AddPhieuGHanDTO addPhieuGHanDTO) {
          if(addPhieuGHanDTO == null)
               return null;

          PhieuGHan.PhieuGHanBuilder phieuGHan = PhieuGHan.builder();
          phieuGHan.ngayGHan(addPhieuGHanDTO.getNgayGHan());
          phieuGHan.note(addPhieuGHanDTO.getNote());
          phieuGHan.isChecked(addPhieuGHanDTO.isChecked());
          Set<PhieuGHanDetail> chitiets = new HashSet<>();
          for(AddPhieuGHanDetailDTO chitiet: addPhieuGHanDTO.getChitiets()) {
               PhieuGHanDetail newDetail = phieuGHanDetailRepository.save(
                      addPhieuGHanDetailMapper.dtoToModel(chitiet)
               );
               chitiets.add(
                       newDetail
               );
          }
          Reader reader = null;
          if (addPhieuGHanDTO.getReaderId() != null){
               reader = readerRepository.findById(addPhieuGHanDTO.getReaderId()).orElseThrow(()
                       -> new CustomException("Không tồn tại độc giả với mã " + addPhieuGHanDTO.getReaderId(), HttpStatus.NOT_FOUND));
          }
          Librarian librarian = null;
          if (addPhieuGHanDTO.getLibrarianId() != null){
               librarian =  librarianRepository.findById(addPhieuGHanDTO.getLibrarianId()).orElseThrow(
                       () -> new CustomException("Không tồn tại thủ thư với mã " + addPhieuGHanDTO.getLibrarianId(), HttpStatus.NOT_FOUND)
               );
          }
          phieuGHan.chitiets(chitiets);
          phieuGHan.librarian(librarian);
          phieuGHan.reader(reader);
          return phieuGHan.build();
     }

}
