package ru.gb.gbshopmart.web.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.gbshopmart.dao.CategoryDao;
import ru.gb.gbshopmart.dao.ManufacturerDao;
import ru.gb.gbshopmart.entity.Category;
import ru.gb.gbshopmart.entity.Manufacturer;
import ru.gb.gbshopmart.entity.Product;
import ru.gb.gbshopmart.web.dto.ProductDto;

import java.util.NoSuchElementException;

@Mapper(uses = {ManufacturerMapper.class, CategoryMapper.class})
public interface ProductMapper {
    @Mapping(source = "created_by", target = "createdBy")
    @Mapping(source = "created_date", target = "createdDate")
    @Mapping(source = "last_modified_by", target = "lastModifiedBy")
    @Mapping(source = "last_modified_date", target = "lastModifiedDate")
    Product toProduct(ProductDto productDto, @Context ManufacturerDao manufacturerDao, @Context CategoryDao categoryDao);

    @Mapping(source = "createdBy", target = "created_by")
    @Mapping(source = "createdDate", target = "created_date")
    @Mapping(source = "lastModifiedBy", target = "last_modified_by")
    @Mapping(source = "lastModifiedDate", target = "last_modified_date")
//    @Mapping(source = "categories", target = "category")
    ProductDto toProductDto(Product product);

    default Manufacturer getManufacturer(String manufacturer, @Context ManufacturerDao manufacturerDao) {
        return manufacturerDao.findByTitle(manufacturer).orElseThrow(NoSuchElementException::new);
    }

    default String getManufacturer(Manufacturer manufacturer) {
        return manufacturer.getTitle();
    }

    default Category getCategory(String category, @Context CategoryDao categoryDao) {
        return categoryDao.findByTitle(category).orElseThrow(NoSuchElementException::new);
    }

    default String getCategory(Category category) {
        return category.getTitle();
    }

}
