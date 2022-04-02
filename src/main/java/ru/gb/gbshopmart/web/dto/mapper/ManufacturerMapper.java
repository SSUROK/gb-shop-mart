package ru.gb.gbshopmart.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.gbshopmart.entity.Manufacturer;
import ru.gb.gbshopmart.web.dto.ManufacturerDto;

@Mapper
public interface ManufacturerMapper {
    @Mapping(source = "created_by", target = "createdBy")
    @Mapping(source = "created_date", target = "createdDate")
    @Mapping(source = "last_modified_by", target = "lastModifiedBy")
    @Mapping(source = "last_modified_date", target = "lastModifiedDate")
    Manufacturer toManufacturer(ManufacturerDto manufacturerDto);

    @Mapping(source = "createdBy", target = "created_by")
    @Mapping(source = "createdDate", target = "created_date")
    @Mapping(source = "lastModifiedBy", target = "last_modified_by")
    @Mapping(source = "lastModifiedDate", target = "last_modified_date")
    ManufacturerDto toManufacturerDto(Manufacturer manufacturer);
}
