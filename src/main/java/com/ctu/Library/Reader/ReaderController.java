package com.ctu.Library.Reader;

import com.ctu.Library.Reader.DTO.AddReaderDTO;
import com.ctu.Library.Reader.DTO.ReaderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReaderDTO> getAllReaders(){
        return readerService.getAllReaders();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReaderDTO addReader(@RequestBody AddReaderDTO addReaderDTO){
        return readerService.addReader(addReaderDTO);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReaderDTO updateReader(@PathVariable Long id, @RequestBody AddReaderDTO newReader){
        return readerService.updateReader(id, newReader);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReaderDTO deleteReader(@PathVariable Long id){
        return readerService.deleteReader(id);
    }
}
