package com.ctu.Library.PhieuMuonDetail.Mapper;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.BookItem.BookItemRepository;
import com.ctu.Library.BookItem.BookItemService;
import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.PhieuMuonDetail.DTO.AddPhieuMuonDetailDTO;
import com.ctu.Library.PhieuMuonDetail.DTO.PhieuMuonDetailDTO;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddPhieuMuonDetailMapper {
    private final BookItemRepository bookItemRepository;
    public PhieuMuonDetail dtoToModel(AddPhieuMuonDetailDTO addPhieuMuonDetailDTO) {
        if ( addPhieuMuonDetailDTO == null ) {
            return null;
        }

        PhieuMuonDetail.PhieuMuonDetailBuilder phieuMuonDetail = PhieuMuonDetail.builder();

        phieuMuonDetail.tinhTrang( addPhieuMuonDetailDTO.getTinhTrang() );
        phieuMuonDetail.hanTra( addPhieuMuonDetailDTO.getHanTra() );
        BookItem bookItem = bookItemRepository.findById(addPhieuMuonDetailDTO.getBookItemId()).orElseThrow(
                () -> new CustomException("Không tồn tại quyển sách với mã " + addPhieuMuonDetailDTO.getBookItemId(), HttpStatus.NOT_FOUND)
        );
        phieuMuonDetail.bookItem(bookItem);
        return phieuMuonDetail.build();
    }
}
