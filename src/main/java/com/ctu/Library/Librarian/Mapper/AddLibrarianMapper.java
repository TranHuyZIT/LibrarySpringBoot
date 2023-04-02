package com.ctu.Library.Librarian.Mapper;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Librarian.DTO.AddLibrarianDTO;
import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.User.User;
import com.ctu.Library.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddLibrarianMapper {
    private final UserRepository userRepository;

    public Librarian dtoToModel(AddLibrarianDTO addLibrarianDTO) {
        if (addLibrarianDTO == null){
            return null;
        }
        Librarian.LibrarianBuilder librarian = Librarian.builder();
        librarian.name(addLibrarianDTO.getName());
        librarian.dob(addLibrarianDTO.getDob());
        librarian.contact(addLibrarianDTO.getContact());
        User user = userRepository.findById(addLibrarianDTO.getUser()).orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + addLibrarianDTO.getUser(), HttpStatus.NOT_FOUND));
        librarian.user(user);
        return librarian.build();
    }
}
