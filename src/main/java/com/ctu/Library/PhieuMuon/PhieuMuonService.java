package com.ctu.Library.PhieuMuon;


import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.BookItemRepository;
import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.PhieuMuon.DTO.AddPhieuMuonDTO;
import com.ctu.Library.PhieuMuon.DTO.PhieuMuonDTO;
import com.ctu.Library.PhieuMuon.Mapper.AddPhieuMuonMapper;
import com.ctu.Library.PhieuMuon.Mapper.PhieuMuonMapper;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PhieuMuonService {
    private final PhieuMuonRepository phieuMuonRepository;
    private final BookItemRepository bookItemRepository;
    private final AddPhieuMuonMapper addPhieuMuonMapper;
    private final PhieuMuonMapper phieuMuonMapper;

    public PhieuMuonDTO addPhieuMuon(AddPhieuMuonDTO addPhieuMuonDTO){
        PhieuMuon phieuMuon = addPhieuMuonMapper.dtoToModel(addPhieuMuonDTO);
        System.out.println(phieuMuon);
        PhieuMuon saved =  phieuMuonRepository.save(phieuMuon);
        return phieuMuonMapper.modelToDTO(
                saved
        );
    }
    public PhieuMuonDTO updatePhieuMuon(Long id, AddPhieuMuonDTO addPhieuMuonDTO){
      PhieuMuon currentPhieuMuon = phieuMuonRepository.findById(id).orElseThrow(
        () -> new CustomException("Không tồn tại phiếu mượn này", HttpStatus.NOT_FOUND));
      PhieuMuon newPhieuMuon = addPhieuMuonMapper.dtoToModel(addPhieuMuonDTO);
      currentPhieuMuon.setNgayMuon(newPhieuMuon.getNgayMuon());
      currentPhieuMuon.setNote(newPhieuMuon.getNote());
      currentPhieuMuon.setChecked(newPhieuMuon.isChecked());
      if (newPhieuMuon.getLibrarian() != null){
        currentPhieuMuon.setLibrarian(newPhieuMuon.getLibrarian());
      }
      if(newPhieuMuon.getReader() != null){
        currentPhieuMuon.setReader(newPhieuMuon.getReader());
      }
      PhieuMuon saved =phieuMuonRepository.save(currentPhieuMuon);
      return phieuMuonMapper.modelToDTO(
        saved
      );

    }
    public Page<PhieuMuon> getAll(Long readerId, Integer pageNo, Integer pageSize, String sortBy, Boolean reverse){
        if (pageNo == -1){
            Pageable pageAndSortingRequest = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(reverse? Sort.Direction.DESC : Sort.Direction. ASC, sortBy));
            return phieuMuonRepository.findAll(pageAndSortingRequest);
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(reverse ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
        if (readerId != null){
            return phieuMuonRepository.findAllByReaderId(readerId, pageable);
        }
        return phieuMuonRepository.findAll(pageable);
    }

    public PhieuMuon delete(Long id){
        PhieuMuon phieuMuon = phieuMuonRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy phiếu mượn có mã là " + id, HttpStatus.NOT_FOUND));
        phieuMuonRepository.delete(phieuMuon);
        return phieuMuon;
    }

    public PhieuMuon findOne(Long id) {
        return phieuMuonRepository.findById(id).orElseThrow(
                () -> new CustomException("Không tìm thấy phiếu mượn có mã là" + id, HttpStatus.NOT_FOUND)
        );
    }

    @Transactional(rollbackOn = {Throwable.class, Exception.class})
    public PhieuMuon checkPhieuMuon(Long id){
        PhieuMuon phieuMuon = phieuMuonRepository.findById(id).orElseThrow(
                () -> new CustomException("Không tìm thấy phiếu mượn có mã này", HttpStatus.NOT_FOUND)
        );
        phieuMuon.setChecked(true);
        Set<PhieuMuonDetail> chitiets = phieuMuon.getChitiets();
        for(PhieuMuonDetail detail : chitiets){
            BookItem bookItem = detail.getBookItem();
            bookItem.setSoLanMuon(bookItem.getSoLanMuon() + 1);
            bookItem.setReader(phieuMuon.getReader());
            bookItem.setHanTra(detail.getHanTra());
            bookItem.setTrangThai(false);
            bookItemRepository.save(bookItem);
        }
        return phieuMuonRepository.save(phieuMuon);
    }
}
