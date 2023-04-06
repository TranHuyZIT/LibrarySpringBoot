package com.ctu.Library.PhieuGHanDetail.Mapper;

import com.ctu.Library.PhieuGHanDetail.DTO.PhieuGHanDetailDTO;
import com.ctu.Library.PhieuGHanDetail.PhieuGHanDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuGHanDetailMapper {
    PhieuGHanDetailDTO modelToDto(PhieuGHanDetail phieuGHanDetail);
    PhieuGHanDetail dtoToModel(PhieuGHanDetailDTO phieuGHanDetailDTO);
}
