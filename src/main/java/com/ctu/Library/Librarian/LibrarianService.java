package com.ctu.Library.Librarian;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Librarian.DTO.AddLibrarianDTO;
import com.ctu.Library.Librarian.DTO.LibrarianDTO;
import com.ctu.Library.Librarian.Mapper.AddLibrarianMapper;
import com.ctu.Library.Librarian.Mapper.LibrarianMapper;
import com.ctu.Library.User.User;
import com.ctu.Library.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Librarian> getAllLibrarians(Integer pageNo, Integer pageSize, String sortBy, Boolean reverse) {
        if (pageNo == -1){
            Pageable pageAndSortingRequest = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(reverse? Sort.Direction.DESC : Sort.Direction. ASC, sortBy));
            return librarianRepository.findAll(pageAndSortingRequest);
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(reverse ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));

        return librarianRepository.findAll(pageable);
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

    public Librarian getLibrarian(long id) {
        return librarianRepository.findOneByUser_Id(id);
    }
}
