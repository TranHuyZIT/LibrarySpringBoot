package com.ctu.Library.Reader.Mapper;

import com.ctu.Library.ExceptionHandling.CustomException;
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
    private UserRepository userRepository ;
    public Reader dtoToModel(com.ctu.Library.Reader.DTO.AddReaderDTO addReaderDTO){
        if (addReaderDTO == null){
            return null;
        }
        Reader.ReaderBuilder reader = Reader.builder();
        reader.name(addReaderDTO.getName());
        reader.birth(addReaderDTO.getBirth() );
        reader.address(addReaderDTO.getAddress() );
        User user = userRepository.findById(
                addReaderDTO.getUser()
        ).orElseThrow(()-> new CustomException("Không tìm thấy danh mục với mã người dùng" + addReaderDTO.getUser(), HttpStatus.NOT_FOUND));
        reader.user(user);
        return reader.build();
    }
}
