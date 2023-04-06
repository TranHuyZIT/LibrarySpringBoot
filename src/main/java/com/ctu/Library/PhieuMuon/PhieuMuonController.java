package com.ctu.Library.PhieuMuon;

import com.ctu.Library.PhieuMuon.DTO.AddPhieuMuonDTO;
import com.ctu.Library.PhieuMuon.DTO.PhieuMuonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/phieumuon")
@RequiredArgsConstructor
public class PhieuMuonController {
    private final PhieuMuonService phieuMuonService;
    @PostMapping
    public PhieuMuonDTO addPhieuMuon(@RequestBody AddPhieuMuonDTO addPhieuMuonDTO){
        return phieuMuonService.addPhieuMuon(addPhieuMuonDTO);
    }
    @GetMapping
    public Page<PhieuMuon> getAll(
            @RequestParam (defaultValue = "", name = "readerId") Long readerId,
            @RequestParam(defaultValue = "0", name="pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", name="pageSize") Integer pageSize,
            @RequestParam(defaultValue = "createdAt", name="sortBy") String sortBy,
            @RequestParam(defaultValue = "true", name="reverse") boolean reverse
    ){
        return phieuMuonService.getAll(readerId, pageNo, pageSize, sortBy, reverse);
    }
    @DeleteMapping("/{id}")
    public PhieuMuon delete(@PathVariable Long id){
        return phieuMuonService.delete(id);
    }
}
