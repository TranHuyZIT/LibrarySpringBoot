package com.ctu.Library.PhieuMuonDetail.Mapper;

import com.ctu.Library.PhieuMuonDetail.DTO.PhieuMuonDetailDTO;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuMuonDetailMapper {
    PhieuMuonDetailDTO modelToDTO(PhieuMuonDetail phieuMuonDetail);
    PhieuMuonDetail dtoToModel(PhieuMuonDetailDTO phieuMuonDetailDTO);
}
