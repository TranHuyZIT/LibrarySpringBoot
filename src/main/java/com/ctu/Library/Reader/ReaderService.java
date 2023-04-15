package com.ctu.Library.Reader;


import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.PhieuMuon.PhieuMuon;
import com.ctu.Library.Reader.DTO.AddReaderDTO;
import com.ctu.Library.Reader.DTO.ReaderDTO;
import com.ctu.Library.Reader.Mapper.AddReaderMapper;
import com.ctu.Library.Reader.Mapper.ReaderMapper;
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
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;
    private final AddReaderMapper addReaderMapper;
    private final UserRepository userRepository;


    public Page<Reader> getAllReaders(String name, Long readerId, Integer pageNo, Integer pageSize, String sortBy, Boolean reverse){
        if (pageNo == -1){
            Pageable pageAndSortingRequest = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(reverse? Sort.Direction.DESC : Sort.Direction. ASC, sortBy));
            if (!Objects.equals(name, "")){
                return readerRepository.findByNameContaining(name, pageAndSortingRequest);
            }
            return readerRepository.findAll(pageAndSortingRequest);
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(reverse ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
        if (readerId != null){
//            return readerRepository.findAllByReader_Id(readerId, pageable);
        }
        if (!Objects.equals(name, "")){
            return readerRepository.findByNameContaining(name, pageable);
        }
        return readerRepository.findAll(pageable);
    }
    public Reader getReader( Long id){
        System.out.println(id);

        Reader reader = readerRepository.findOneByUser_Id(id);
        System.out.println(reader);
        return reader;
    }
    public ReaderDTO addReader(AddReaderDTO addReaderDTO){
        Reader reader = addReaderMapper.dtoToModel(addReaderDTO);
        return readerMapper.modelToDTO(readerRepository.save(reader));
    }

    public ReaderDTO deleteReader( Long id){
        Reader del_reader = readerRepository.findById(id).orElseThrow(() -> new CustomException("Không tìm thấy người dùng cần xóa với mã " + id, HttpStatus.NOT_FOUND));
        readerRepository.delete(del_reader);
        return readerMapper.modelToDTO(del_reader);
    }

    public ReaderDTO updateReader( Long id, AddReaderDTO addReaderDTO){
        Reader currentReader = getReader(id);
        Reader newReader = addReaderMapper.dtoToModel(addReaderDTO);

        currentReader.setName(newReader.getName());
        currentReader.setAddress(newReader.getAddress());
        currentReader.setPhone(newReader.getPhone());
        currentReader.setEmail(newReader.getEmail());
        currentReader.setBirth(newReader.getBirth());

        Reader saved = readerRepository.save(currentReader);
        return  readerMapper.modelToDTO(saved);
    }

}
