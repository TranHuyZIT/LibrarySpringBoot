package com.ctu.Library.Librarian.Mapper;

import com.ctu.Library.Librarian.DTO.AddLibrarianDTO;
import com.ctu.Library.Librarian.DTO.LibrarianDTO;
import com.ctu.Library.Librarian.Librarian;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibrarianMapper {
    Librarian dtoToModel(LibrarianDTO librarianDTO);
    LibrarianDTO modelToDto(Librarian librarian);
}
