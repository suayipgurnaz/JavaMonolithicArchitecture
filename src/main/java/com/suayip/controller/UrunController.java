package com.suayip.controller;

import com.suayip.dto.request.UrunSaveRequestDto;
import com.suayip.excepiton.EErrorType;
import com.suayip.excepiton.SatisManagerException;
import com.suayip.repository.entity.Urun;
import com.suayip.service.UrunService;
import com.suayip.constants.EndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EndPoints.API+ EndPoints.VERSION+ EndPoints.URUN)
@RequiredArgsConstructor
public class UrunController {
    private final UrunService urunService;

    @PostMapping(EndPoints.SAVE)
    public ResponseEntity<Void> save(UrunSaveRequestDto dto){
        urunService.saveDto(dto);
       return ResponseEntity.ok().build();
    }

    @GetMapping(EndPoints.GETALL)
    public ResponseEntity<List<Urun>> findAll(){
        return ResponseEntity.ok(urunService.findAll());
    }

    /**
     * localhost:9090/api/v1/urun/getbyad?ad=muhammet
     * @param ad
     * @return
     * @throws Exception
     */
    @GetMapping("/getbyad")
    public ResponseEntity<String> getAllByAd(String ad) throws Exception {
        if(ad == null)
            throw new SatisManagerException(EErrorType.URUN_EKLEME,"Ürün eklemede ad bilgisi boş geldiği için hata oluştu");
        return ResponseEntity.ok("Herşey yolunda");
    }

}
