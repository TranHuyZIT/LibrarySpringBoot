package com.ctu.Library.Reader.Mapper;


import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Reader.DTO.AddReaderDTO;
import com.ctu.Library.Reader.Reader;
import com.ctu.Library.Reader.DTO.ReaderDTO;
import com.ctu.Library.Reader.ReaderRepository;
import com.ctu.Library.User.User;
import com.ctu.Library.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface ReaderMapper {
    public Reader dtoToModel(ReaderDTO readerDTO) ;
    public ReaderDTO modelToDTO(Reader reader);

}
