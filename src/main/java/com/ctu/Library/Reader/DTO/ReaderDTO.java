package com.ctu.Library.Reader.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;


@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ReaderDTO {
    private Long id;
    private String name;
    private Date birth;
    private String address;
    private String phone;
    private String email;
}
