package com.ctu.Library.PhieuGHan.Mapper;

import com.ctu.Library.PhieuGHan.DTO.PhieuGHanDTO;
import com.ctu.Library.PhieuGHan.PhieuGHan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuGHanMapper {
    PhieuGHanDTO modelToDto(PhieuGHan phieuGHan);
    PhieuGHan dtoToModel(PhieuGHanDTO phieuGHanDTO);
}
