package com.ctu.Library.Book.DTO;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.DTO.AddBookItemDTO;
import com.ctu.Library.Category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AddBookDTO {
    private String ten;
    private String namXB;
    private String tacGia;
    private Long categoryId;
    private Set<AddBookItemDTO> listBookItem;
}
