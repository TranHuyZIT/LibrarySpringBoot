package com.ctu.Library.PhieuTra.Mapper;

import com.ctu.Library.PhieuTra.DTO.PhieuTraDTO;
import com.ctu.Library.PhieuTra.PhieuTra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuTraMapper {
    public PhieuTraDTO modelToDTO(PhieuTra phieuTra);
    public PhieuTra dtoTOModel(PhieuTraDTO phieuTraDTO);
}
