package com.ctu.Library.PhieuTraDetail.Mapper;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.BookItemRepository;
import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.PhieuMuonDetail.DTO.AddPhieuMuonDetailDTO;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import com.ctu.Library.PhieuTraDetail.DTO.AddPhieuTraDetailDTO;
import com.ctu.Library.PhieuTraDetail.PhieuTraDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddPhieuTraDetailMapper {
    private final BookItemRepository bookItemRepository;
    public PhieuTraDetail dtoToModel(AddPhieuTraDetailDTO addPhieuTraDetailDTO) {
        if ( addPhieuTraDetailDTO == null ) {
            return null;
        }

        PhieuTraDetail.PhieuTraDetailBuilder phieuTraDetail = PhieuTraDetail.builder();
        phieuTraDetail.tinhTrang( addPhieuTraDetailDTO.getTinhTrang() );
        BookItem bookItem = bookItemRepository.findById(addPhieuTraDetailDTO.getBookItemId()).orElseThrow(
                () -> new CustomException("Không tồn tại quyển sách với mã " + addPhieuTraDetailDTO.getBookItemId(), HttpStatus.NOT_FOUND)
        );
        phieuTraDetail.bookItem(bookItem);
        return phieuTraDetail.build();
    }
}
