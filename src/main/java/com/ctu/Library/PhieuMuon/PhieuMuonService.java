package com.ctu.Library.PhieuMuon;


import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.PhieuMuon.DTO.AddPhieuMuonDTO;
import com.ctu.Library.PhieuMuon.DTO.PhieuMuonDTO;
import com.ctu.Library.PhieuMuon.Mapper.AddPhieuMuonMapper;
import com.ctu.Library.PhieuMuon.Mapper.PhieuMuonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhieuMuonService {
    private final PhieuMuonRepository phieuMuonRepository;
    private final AddPhieuMuonMapper addPhieuMuonMapper;
    private final PhieuMuonMapper phieuMuonMapper;

    public PhieuMuonDTO addPhieuMuon(AddPhieuMuonDTO addPhieuMuonDTO){
        PhieuMuon phieuMuon = addPhieuMuonMapper.dtoToModel(addPhieuMuonDTO);
        PhieuMuon saved =  phieuMuonRepository.save(phieuMuon);
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
//            return phieuMuonRepository.findAllByReader_Id(readerId, pageable);
        }
        return phieuMuonRepository.findAll(pageable);
    }

    public PhieuMuon delete(Long id){
        PhieuMuon phieuMuon = phieuMuonRepository.findById(id)
                .orElseThrow(() -> new CustomException("Không tìm thấy phiếu mượn có mã là " + id, HttpStatus.NOT_FOUND));
        phieuMuonRepository.delete(phieuMuon);
        return phieuMuon;
    }

}
