package com.ctu.Library.PhieuTra;


import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.BookItemRepository;
import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import com.ctu.Library.PhieuTra.DTO.AddPhieuTraDTO;
import com.ctu.Library.PhieuTra.DTO.PhieuTraDTO;
import com.ctu.Library.PhieuTra.Mapper.AddPhieuTraMapper;
import com.ctu.Library.PhieuTra.Mapper.PhieuTraMapper;
import com.ctu.Library.PhieuTraDetail.PhieuTraDetail;
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
public class PhieuTraService {
    private final PhieuTraRepository phieuTraRepository;
    private final AddPhieuTraMapper addPhieuTraMapper;
    private final BookItemRepository bookItemRepository;
    private final PhieuTraMapper phieuTraMapper;

    public PhieuTraDTO addPhieuTra(AddPhieuTraDTO addPhieuTraDTO){
        PhieuTra phieuTra = addPhieuTraMapper.dtoToModel(addPhieuTraDTO);
        PhieuTra saved =  phieuTraRepository.save(phieuTra);
        return phieuTraMapper.modelToDTO(
                saved
        );
    }
    public Page<PhieuTra> getAll(Long readerId, Integer pageNo, Integer pageSize, String sortBy, Boolean reverse){
        if (pageNo == -1){
            Pageable pageAndSortingRequest = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(reverse? Sort.Direction.DESC : Sort.Direction. ASC, sortBy));
            return phieuTraRepository.findAll(pageAndSortingRequest);
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(reverse ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
        if (readerId != null){
            return phieuTraRepository.findAllByReaderId(readerId, pageable);
        }
        return phieuTraRepository.findAll(pageable);
    }

    public PhieuTra delete(Long id){
        PhieuTra phieuTra = phieuTraRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy phiếu mượn có mã là " + id, HttpStatus.NOT_FOUND));
        phieuTraRepository.delete(phieuTra);
        return phieuTra;
    }

    public PhieuTra getOne(Long id) {
        return phieuTraRepository.findById(id).orElseThrow(
                () -> new CustomException("KhÔng tìm thấy phiếu trả có mã này", HttpStatus.NOT_FOUND)
        );
    }
    @Transactional(rollbackOn = {Throwable.class, Exception.class})
    public PhieuTra check(Long id){
        PhieuTra phieuTra = phieuTraRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy phiếu mượn có mã là " + id, HttpStatus.NOT_FOUND));
        Set<PhieuTraDetail> chitiets = phieuTra.getChitiets();
        phieuTra.setChecked(true);
        for(PhieuTraDetail detail: chitiets) {
            BookItem bookItem = detail.getBookItem();
            bookItem.setReader(null);
            bookItem.setHanTra(null);
            bookItem.setTrangThai(true);
            bookItemRepository.save(bookItem);
        }
        return phieuTraRepository.save(phieuTra);
    }
}
