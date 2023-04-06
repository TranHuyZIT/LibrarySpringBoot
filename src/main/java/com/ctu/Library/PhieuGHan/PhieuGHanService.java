package com.ctu.Library.PhieuGHan;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.PhieuGHan.DTO.AddPhieuGHanDTO;
import com.ctu.Library.PhieuGHan.DTO.PhieuGHanDTO;
import com.ctu.Library.PhieuGHan.Mapper.AddPhieuGHanMapper;
import com.ctu.Library.PhieuGHan.Mapper.PhieuGHanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhieuGHanService {
    public final PhieuGHanRepository phieuGHanRepository;
    public final PhieuGHanMapper phieuGHanMapper;
    public final AddPhieuGHanMapper addPhieuGHanMapper;

    public Page<PhieuGHan> getAll(Integer pageNo, Integer pageSize, String sortBy, Boolean reverse){
        if (pageNo == -1){
            Pageable pageAndSortingRequest = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(reverse? Sort.Direction.DESC : Sort.Direction. ASC, sortBy));
            return phieuGHanRepository.findAll(pageAndSortingRequest);
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(reverse ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
        return phieuGHanRepository.findAll(pageable);
    }

    public PhieuGHanDTO addPhieuGHan(AddPhieuGHanDTO addPhieuGHanDTO){
        PhieuGHan phieuGHan = addPhieuGHanMapper.dtoToModel(addPhieuGHanDTO);
        PhieuGHan saved =  phieuGHanRepository.save(phieuGHan);
        return phieuGHanMapper.modelToDto(
                saved
        );
    }

    public PhieuGHan delete(Long id){
        PhieuGHan phieuGHan = phieuGHanRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy phiếu mượn có mã là " + id, HttpStatus.NOT_FOUND));
        phieuGHanRepository.delete(phieuGHan);
        return phieuGHan;
    }
}
