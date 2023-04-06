package com.ctu.Library.PhieuGHanDetail.Mapper;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.BookItemRepository;
import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.PhieuGHanDetail.DTO.AddPhieuGHanDetailDTO;
import com.ctu.Library.PhieuGHanDetail.PhieuGHanDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddPhieuGHanDetailMapper {
    private final BookItemRepository bookItemRepository;
    public PhieuGHanDetail dtoToModel(AddPhieuGHanDetailDTO addPhieuGHanDetailDTO) {
        if ( addPhieuGHanDetailDTO == null ) {
            return null;
        }

        PhieuGHanDetail.PhieuGHanDetailBuilder phieuGHanDetail = PhieuGHanDetail.builder();

        phieuGHanDetail.tinhTrang( addPhieuGHanDetailDTO.getTinhTrang() );
        phieuGHanDetail.hanTra( addPhieuGHanDetailDTO.getHanTra() );
        BookItem bookItem = bookItemRepository.findById(addPhieuGHanDetailDTO.getBookItemId()).orElseThrow(
                () -> new CustomException("Không tồn tại quyển sách với mã " + addPhieuGHanDetailDTO.getBookItemId(), HttpStatus.NOT_FOUND)
        );
        phieuGHanDetail.bookItem(bookItem);
        return phieuGHanDetail.build();
    }
}
