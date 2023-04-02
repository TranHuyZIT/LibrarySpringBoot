package com.ctu.Library.Reader;

import com.ctu.Library.Reader.DTO.AddReaderDTO;
import com.ctu.Library.Reader.DTO.ReaderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    @GetMapping
    public Page<Reader> getAllReaders(
                @RequestParam (defaultValue = "", name = "readerId") Long readerId,
                @RequestParam(defaultValue = "0", name="pageNo") Integer pageNo,
                @RequestParam(defaultValue = "10", name="pageSize") Integer pageSize,
                @RequestParam(defaultValue = "createdAt", name="sortBy") String sortBy,
                @RequestParam(defaultValue = "true", name="reverse") boolean reverse
    ){
        return readerService.getAllReaders( readerId, pageNo, pageSize, sortBy, reverse);
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
