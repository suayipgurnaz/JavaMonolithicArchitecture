package com.suayip.service;
import com.suayip.dto.request.MusteriSaveRequestDto;
import com.suayip.dto.response.MusteriFindAllResponseDto;
import com.suayip.mapper.IMusteriMapper;
import com.suayip.repository.IMusteriRepository;
import com.suayip.repository.entity.Musteri;
import com.suayip.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusteriService extends ServiceManager<Musteri,Long> {
  private final IMusteriRepository repository;
  public MusteriService(IMusteriRepository repository){
      super(repository);
      this.repository=repository;
  }
  public Musteri findByAd(String ad) {
    return repository.findByAd(ad);
  }

  public void saveDto(MusteriSaveRequestDto dto){
//      Musteri musteri = Musteri.builder()
//              .ad(dto.getAd())
//              .adres(dto.getAdres())
//              .telefon(dto.getTelefon())
//              .build();
//      save(musteri);
      save(IMusteriMapper.INSTANCE.bakSenOlusturDtoDanMusteri(dto));
  }

  public List<MusteriFindAllResponseDto> findAllResponseDtos(){
      List<MusteriFindAllResponseDto> result = new ArrayList<>();
      findAll().forEach(x->{
//          result.add(MusteriFindAllResponseDto.builder()
//                          .ad(x.getAd())
//                          .username(x.getUsername())
//                          .img(x.getImg())
//                  .build());
          result.add(IMusteriMapper.INSTANCE.formMusteri(x));
      });
      return result;
  }

  public Boolean doLogin(String username,String password){
     Optional<Musteri> musteri = repository.findOptionalByUsernameAndPassword(username, password);
     if(musteri.isEmpty()) return false;
     return true;
  }

}
