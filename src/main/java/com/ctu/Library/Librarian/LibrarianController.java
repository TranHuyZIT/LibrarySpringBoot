package com.ctu.Library.Librarian;


import com.ctu.Library.Librarian.DTO.AddLibrarianDTO;
import com.ctu.Library.Librarian.DTO.LibrarianDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Librarian> getAllLibrarians(
            @RequestParam (defaultValue = "", name = "readerId") Long readerId,
            @RequestParam(defaultValue = "0", name="pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", name="pageSize") Integer pageSize,
            @RequestParam(defaultValue = "createdAt", name="sortBy") String sortBy,
            @RequestParam(defaultValue = "true", name="reverse") boolean reverse
    ){
        return librarianService.getAllLibrarians(readerId, pageNo, pageSize, sortBy, reverse);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LibrarianDTO addLibrarian(@RequestBody AddLibrarianDTO addLibrarianDTO){
        return librarianService.addLibrarian(addLibrarianDTO);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LibrarianDTO updateLibrarian(@PathVariable Long id, @RequestBody AddLibrarianDTO addLibrarianDTO){
        return librarianService.updateLibrarian(id, addLibrarianDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LibrarianDTO deleteLibrarian(@PathVariable Long id) {
        return librarianService.deleteLibrarian(id);
    }
}
