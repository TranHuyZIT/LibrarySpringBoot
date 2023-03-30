package com.ctu.Library.Reader.Mapper;

import com.ctu.Library.Reader.Reader;
import com.ctu.Library.Reader.DTO.ReaderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReaderMapper {
    Reader dtoToModel(ReaderDTO readerDTO);
    ReaderDTO modelToDTO(Reader reader);
}
