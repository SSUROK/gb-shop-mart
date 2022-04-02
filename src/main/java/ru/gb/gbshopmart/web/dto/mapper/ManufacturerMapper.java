package ru.gb.gbshopmart.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.gbshopmart.entity.Manufacturer;
import ru.gb.gbshopmart.web.dto.ManufacturerDto;

@Mapper
public interface ManufacturerMapper {
    Manufacturer toManufacturer(ManufacturerDto manufacturerDto);

    ManufacturerDto toManufacturerDto(Manufacturer manufacturer);
}
