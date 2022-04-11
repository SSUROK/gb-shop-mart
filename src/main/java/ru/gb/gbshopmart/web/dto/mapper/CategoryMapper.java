package ru.gb.gbshopmart.web.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.gbapi.category.dto.CategoryDto;
import ru.gb.gbshopmart.dao.CategoryDao;
import ru.gb.gbshopmart.dao.ManufacturerDao;
import ru.gb.gbshopmart.dao.ProductDao;
import ru.gb.gbshopmart.entity.Category;
import ru.gb.gbshopmart.entity.Product;

import java.util.NoSuchElementException;

@Mapper(uses = ProductMapper.class)
public interface CategoryMapper {
    Category toCategory(CategoryDto categoryDto);

    CategoryDto toCategoryDto(Category category);

    default String getProduct(Product product) {
        return product.getTitle();
    }

    default Product getProduct(String product, @Context ProductDao productDao) {
        return productDao.findByTitle(product).orElseThrow(NoSuchElementException::new);
    }
}