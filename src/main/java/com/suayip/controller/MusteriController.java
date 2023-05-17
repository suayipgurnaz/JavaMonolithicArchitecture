package com.suayip.controller;

import com.suayip.dto.request.MusteriSaveRequestDto;
import com.suayip.dto.response.MusteriFindAllResponseDto;
import com.suayip.repository.entity.Musteri;
import com.suayip.service.MusteriService;
import com.suayip.constants.EndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller - RestController
 * MVC        - RestApi İstekleri için
 * RequestMapping -> Uygulamanıza gelen isteklerin URL içinden analiz edilerek
 * ulaşması gereken sınıfa ulaştırılması için kullanılır.
 * Aslında Filter işlemi yapılarak yönlendirme yapılmaktadır.
 */
@RestController
// localhost:9090/musteri
@RequestMapping(EndPoints.API+ EndPoints.VERSION+ EndPoints.MUSTERI)
@RequiredArgsConstructor
public class MusteriController {
    private final MusteriService musteriService;

    /**
     * !!!!DİKKAT!!!!
     * RestApi data iletme ve alma işlemlerini yapar, burada data gönderimi ve alımı
     * olabildiğince amaca yönelik ve kısıtlı olmalıdır.
     * Bu nedenle, gereksiz şekilde dönülen Entity ler ve  datalar,
     * 1- güvenlik açığı oluşturur.
     * 2- performansı mahveder.
     * Bu sorunu çözmek adına DataTransferObject-DTO kullanırız. Dto ayrıca
     * talep ettiğimiz alanların validasyonunu yapmak içinde kullanılır.
     */

    /**
     * Bu sınıf içerisine getirilen isteklerin hangi method u tetikleyeceğinin bilinmesine
     * ihtiyaç vardır. Bu nedenle methodları işaretlememiz gerekir. Bu işaretleme işlemini
     * Post, Put,Get,Delete v.s. gibi işlemlere göre yaparız.
     *
     */

    /**
     * http://localhost:9090/musteri/save
     * ResponseEntity -> Kullanıcıya dönülecek olan datanın bir Varlık olarak
     * dönmesi ve bu varığın Json formatında dönmesi için kullanırız.
     * http://localhost:9090/musteri/save?ad=muhammet&adres=Ankara&telefon=05556669988
     */
    @GetMapping(EndPoints.SAVE)
    public ResponseEntity<String> save(MusteriSaveRequestDto dto){
        musteriService.saveDto(dto);
        return ResponseEntity.ok("Ok.");
    }

    /**
     *
     * http://localhost:9090/musteri/getall
     */
    @GetMapping(EndPoints.GETALL)
    public ResponseEntity<List<MusteriFindAllResponseDto>> findAll(){
        return ResponseEntity.ok(musteriService.findAllResponseDtos());
    }

    @GetMapping(EndPoints.GETBYAD)
    public ResponseEntity<Musteri> findByAd(String ad){
        return ResponseEntity.ok(musteriService.findByAd(ad));
    }

}
