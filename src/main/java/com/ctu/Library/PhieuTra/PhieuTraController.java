package com.ctu.Library.PhieuTra;

import com.ctu.Library.PhieuTra.DTO.AddPhieuTraDTO;
import com.ctu.Library.PhieuTra.DTO.PhieuTraDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/phieutra")
@RequiredArgsConstructor
public class PhieuTraController {
    private final PhieuTraService phieuTraService;
    @PostMapping
    public PhieuTraDTO addPhieuTra(@RequestBody AddPhieuTraDTO addPhieuTraDTO){
        return phieuTraService.addPhieuTra(addPhieuTraDTO);
    }
    @GetMapping
    public Page<PhieuTra> getAll(
            @RequestParam (defaultValue = "", name = "readerId") Long readerId,
            @RequestParam(defaultValue = "0", name="pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", name="pageSize") Integer pageSize,
            @RequestParam(defaultValue = "createdAt", name="sortBy") String sortBy,
            @RequestParam(defaultValue = "true", name="reverse") boolean reverse
    ){
        return phieuTraService.getAll(readerId, pageNo, pageSize, sortBy, reverse);
    }
    @DeleteMapping
    public PhieuTra delete(@PathVariable Long id){
        return phieuTraService.delete(id);
    }
}
