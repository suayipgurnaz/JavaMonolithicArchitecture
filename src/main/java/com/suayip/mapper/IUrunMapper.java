package com.suayip.mapper;

import com.suayip.dto.request.UrunSaveRequestDto;
import com.suayip.repository.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IUrunMapper {
    IUrunMapper INSTANCE = Mappers.getMapper(IUrunMapper.class);

    Urun toUrun(final UrunSaveRequestDto dto);
}
