package com.ctu.Library.Reader;


import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Reader.DTO.AddReaderDTO;
import com.ctu.Library.Reader.DTO.ReaderDTO;
import com.ctu.Library.Reader.Mapper.AddReaderMapper;
import com.ctu.Library.Reader.Mapper.ReaderMapper;
import com.ctu.Library.User.User;
import com.ctu.Library.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;
    private final AddReaderMapper addReaderMapper;
    private final UserRepository userRepository;
    public List<ReaderDTO> getAllReaders(){
        List<ReaderDTO> result = new ArrayList<>();
        for(Reader reader : readerRepository.findAll()){
            result.add(
                    readerMapper.modelToDTO(reader)
            );
        }
        return result;
    }

//    public ReaderDTO addReader(Reader reader){
//
//        return readerMapper.modelToDTO(readerRepository.save(reader));
//    }

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
        Reader currentReader = readerRepository.findById(id).orElseThrow(() -> new CustomException("Không tìm thấy người dùng với mã " + id, HttpStatus.NOT_FOUND));
        Reader newReader = addReaderMapper.dtoToModel(addReaderDTO);

        currentReader.setName(newReader.getName());
        currentReader.setBirth(newReader.getBirth());
        currentReader.setAddress(newReader.getAddress());
        currentReader.setPhone(newReader.getPhone());
        currentReader.setEmail(newReader.getEmail());

        User user = userRepository.findById(addReaderDTO.getUser()).orElseThrow(() -> new CustomException("Không tìm thấy người dùng với mã " + id, HttpStatus.NOT_FOUND));
        currentReader.setUser(user);

        Reader saved = readerRepository.save(currentReader);
        return  readerMapper.modelToDTO(saved);
    }

}
