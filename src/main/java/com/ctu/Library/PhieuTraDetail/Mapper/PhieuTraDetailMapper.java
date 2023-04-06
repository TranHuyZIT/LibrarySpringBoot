package com.ctu.Library.PhieuTraDetail.Mapper;

import com.ctu.Library.PhieuTraDetail.DTO.PhieuTraDetailDTO;
import com.ctu.Library.PhieuTraDetail.PhieuTraDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuTraDetailMapper {
    PhieuTraDetailDTO modelToDTO(PhieuTraDetail phieuMuonDetail);
    PhieuTraDetail dtoToModel(PhieuTraDetailDTO phieuMuonDetailDTO);
}
