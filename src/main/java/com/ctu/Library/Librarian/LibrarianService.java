package com.ctu.Library.Librarian;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Librarian.DTO.LibrarianDTO;
import com.ctu.Library.Librarian.Mapper.LibrarianMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;
    private final LibrarianMapper librarianMapper;

    public List<LibrarianDTO> getAllLibrarians() {
        List<LibrarianDTO> result = new ArrayList<>();
        for(Librarian librarian : librarianRepository.findAll()) {
            result.add(
              librarianMapper.modelToDto(librarian)
            );
        }
        return result;
    }

    public LibrarianDTO addLibrarian(Librarian librarian) {
        System.out.println(librarian);
        return librarianMapper.modelToDto(librarianRepository.save(librarian));
    }

    public  LibrarianDTO deleteLibrarian(Long id) {
        Librarian librarian = librarianRepository.findById(id).orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        librarianRepository.delete(librarian);
        return librarianMapper.modelToDto(librarian);
    }

    public LibrarianDTO updateLibrarian(Long id, Librarian newLibrarian){
        Librarian currentLibrarian = librarianRepository.findById(id).orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        currentLibrarian.setName(newLibrarian.getName());
        currentLibrarian.setDob(newLibrarian.getDob());
        currentLibrarian.setContact(newLibrarian.getContact());
        Librarian saved = librarianRepository.save(currentLibrarian);
        return librarianMapper.modelToDto(saved);
    }
}
