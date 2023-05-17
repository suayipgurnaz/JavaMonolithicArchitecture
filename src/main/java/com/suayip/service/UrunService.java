package com.suayip.service;

import com.suayip.dto.request.UrunSaveRequestDto;
import com.suayip.mapper.IUrunMapper;
import com.suayip.repository.IUrunRepository;
import com.suayip.repository.entity.Urun;
import com.suayip.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UrunService extends ServiceManager<Urun,Long> {
    private final IUrunRepository repository;
    public UrunService(IUrunRepository repository){
        super(repository);
        this.repository=repository;
    }
    public void saveDto(UrunSaveRequestDto dto){
        save(IUrunMapper.INSTANCE.toUrun(dto));
    }
}
