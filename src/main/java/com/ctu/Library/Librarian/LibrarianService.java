package com.ctu.Library.Librarian;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Librarian.DTO.AddLibrarianDTO;
import com.ctu.Library.Librarian.DTO.LibrarianDTO;
import com.ctu.Library.Librarian.Mapper.AddLibrarianMapper;
import com.ctu.Library.Librarian.Mapper.LibrarianMapper;
import com.ctu.Library.User.User;
import com.ctu.Library.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;
    private final AddLibrarianMapper addLibrarianMapper;
    private final LibrarianMapper librarianMapper;
    private final UserRepository userRepository;

    public List<LibrarianDTO> getAllLibrarians() {
        List<LibrarianDTO> result = new ArrayList<>();
        for(Librarian librarian : librarianRepository.findAll()) {
            result.add(
              librarianMapper.modelToDto(librarian)
            );
        }
        return result;
    }

    public LibrarianDTO addLibrarian(AddLibrarianDTO addLibrarianDTO) {
        Librarian librarian = addLibrarianMapper.dtoToModel(addLibrarianDTO);
        return librarianMapper.modelToDto(librarianRepository.save(librarian));
    }

    public  LibrarianDTO deleteLibrarian(Long id) {
        Librarian librarian = librarianRepository.findById(id).orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        librarianRepository.delete(librarian);
        return librarianMapper.modelToDto(librarian);
    }

    public LibrarianDTO updateLibrarian(Long id, AddLibrarianDTO addLibrarianDTO){
        Librarian currentLibrarian = librarianRepository.findById(id).orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        Librarian newLibrarian = addLibrarianMapper.dtoToModel(addLibrarianDTO);
        currentLibrarian.setName(newLibrarian.getName());
        currentLibrarian.setDob(newLibrarian.getDob());
        currentLibrarian.setContact(newLibrarian.getContact());
        currentLibrarian.setUser(userRepository.findById(addLibrarianDTO.getUser()).orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + addLibrarianDTO.getUser(), HttpStatus.NOT_FOUND)));
        Librarian saved = librarianRepository.save(currentLibrarian);
        return librarianMapper.modelToDto(saved);
    }
}
