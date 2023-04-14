package com.ctu.Library.Reader.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Builder
@RequiredArgsConstructor
@Data
@AllArgsConstructor

public class AddReaderDTO {
    private String name;
    private String address;
    private Date birth;
    private String phone;
    private String email;
}
