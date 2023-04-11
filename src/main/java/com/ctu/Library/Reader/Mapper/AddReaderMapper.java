package com.ctu.Library.Reader.Mapper;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Reader.DTO.AddReaderDTO;
import com.ctu.Library.Reader.Reader;
import com.ctu.Library.User.User;
import com.ctu.Library.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component

public class AddReaderMapper {
    private final UserRepository userRepository ;
    public Reader dtoToModel(AddReaderDTO addReaderDTO){
        if (addReaderDTO == null){
            return null;
        }
        Reader.ReaderBuilder reader = Reader.builder();
        reader.name(addReaderDTO.getName());
        reader.address(addReaderDTO.getAddress() );
        reader.phone(addReaderDTO.getPhone());
        reader.email(addReaderDTO.getEmail());
        return reader.build();
    }
}
