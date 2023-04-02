package com.ctu.Library.PhieuMuon.Mapper;

import com.ctu.Library.PhieuMuon.DTO.AddPhieuMuonDTO;
import com.ctu.Library.PhieuMuon.PhieuMuon;
import com.ctu.Library.PhieuMuonDetail.DTO.PhieuMuonDetailDTO;
import com.ctu.Library.PhieuMuonDetail.Mapper.PhieuMuonDetailMapper;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AddPhieuMuonMapper {
    private final PhieuMuonDetailMapper phieuMuonDetailMapper;
    private final PhieuMuonDetailRepository phieuMuonDetailRepository;
    public PhieuMuon dtoToModel(AddPhieuMuonDTO addPhieuMuonDTO){
        if (addPhieuMuonDTO == null){
            return null;
        }
        PhieuMuon.PhieuMuonBuilder phieuMuon = PhieuMuon.builder();
        phieuMuon.ngayMuon(addPhieuMuonDTO.getNgayMuon());
        phieuMuon.note(addPhieuMuonDTO.getNote());
        Set<PhieuMuonDetail> chitiets = new HashSet<>();
        for(PhieuMuonDetailDTO chitiet: addPhieuMuonDTO.getChitiets()){
            PhieuMuonDetail newDetail = phieuMuonDetailRepository.save(
                    phieuMuonDetailMapper.dtoToModel(chitiet)
            );
            chitiets.add(
                    newDetail
            );
        }
        phieuMuon.chitiets(chitiets);
        return phieuMuon.build();
    }
}
