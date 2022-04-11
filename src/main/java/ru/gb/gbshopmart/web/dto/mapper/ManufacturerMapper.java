package ru.gb.gbshopmart.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.gbapi.manufacturer.dto.ManufacturerDto;
import ru.gb.gbshopmart.entity.Manufacturer;

@Mapper
public interface ManufacturerMapper {
    Manufacturer toManufacturer(ManufacturerDto manufacturerDto);

    ManufacturerDto toManufacturerDto(Manufacturer manufacturer);
}
