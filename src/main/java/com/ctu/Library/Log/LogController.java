package com.ctu.Library.Log;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/log")
@RequiredArgsConstructor
public class LogController {
    private final LogRepository logRepository;
    @GetMapping
    public Page<Log> getAllLogs(
            @RequestParam(defaultValue = "0", name="pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", name="pageSize") Integer pageSize,
            @RequestParam(defaultValue = "createdAt", name="sortBy") String sortBy,
            @RequestParam(defaultValue = "true", name="reverse") boolean reverse
    ){
        Pageable pageable;
        if (pageNo == 0){
            pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(reverse? Sort.Direction.DESC : Sort.Direction. ASC, sortBy));
            return logRepository.findAll(pageable);
        }
        pageable = PageRequest.of(pageNo - 1, pageSize , Sort.by(reverse ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
        return logRepository.findAll(pageable);
    }
}
