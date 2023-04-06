package com.ctu.Library.PhieuGHan;

import com.ctu.Library.PhieuGHan.DTO.AddPhieuGHanDTO;
import com.ctu.Library.PhieuGHan.DTO.PhieuGHanDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/phieughan")
@RequiredArgsConstructor
public class PhieuGHanController {
    public final PhieuGHanService phieuGHanService;
    @GetMapping
    public Page<PhieuGHan> getAll(
            @RequestParam(defaultValue = "", name = "readerId") Long readerId,
            @RequestParam(defaultValue = "0", name="pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", name="pageSize") Integer pageSize,
            @RequestParam(defaultValue = "createdAt", name="sortBy") String sortBy,
            @RequestParam(defaultValue = "true", name="reverse") boolean reverse
    ){
        return phieuGHanService.getAll(pageNo, pageSize, sortBy, reverse);
    }

    @PostMapping
    public PhieuGHanDTO addPhieuGHan(@RequestBody AddPhieuGHanDTO addPhieuGHanDTO){
        return phieuGHanService.addPhieuGHan(addPhieuGHanDTO);
    }

    @DeleteMapping
    public PhieuGHan delete(@PathVariable Long id){
        return phieuGHanService.delete(id);
    }
}
