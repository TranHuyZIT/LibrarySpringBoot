package com.ctu.Library.PhieuMuon.Mapper;

import com.ctu.Library.PhieuMuon.DTO.PhieuMuonDTO;
import com.ctu.Library.PhieuMuon.PhieuMuon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuMuonMapper {
    public PhieuMuonDTO modelToDTO(PhieuMuon phieuMuon);
    public PhieuMuon dtoTOModel(PhieuMuonDTO phieuMuonDTO);
}
