package ru.gb.gbshopmart.web.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.gbshopmart.dao.ManufacturerDao;
import ru.gb.gbshopmart.entity.Category;
import ru.gb.gbshopmart.entity.Product;
import ru.gb.gbshopmart.web.dto.CategoryDto;
import ru.gb.gbshopmart.web.dto.ProductDto;

@Mapper
public interface CategoryMapper {
    @Mapping(source = "created_by", target = "createdBy")
    @Mapping(source = "created_date", target = "createdDate")
    @Mapping(source = "last_modified_by", target = "lastModifiedBy")
    @Mapping(source = "last_modified_date", target = "lastModifiedDate")
    Category toCategory(CategoryDto categoryDto);

    @Mapping(source = "createdBy", target = "created_by")
    @Mapping(source = "createdDate", target = "created_date")
    @Mapping(source = "lastModifiedBy", target = "last_modified_by")
    @Mapping(source = "lastModifiedDate", target = "last_modified_date")
    CategoryDto toCategoryDto(Category category);
}
