package ru.gb.gbshopmart.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbapi.common.enums.Status;
import ru.gb.gbshopmart.entity.Category;
import ru.gb.gbshopmart.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findAllByStatus(Status status);
    List<Product> findAllByStatus(Status status, Pageable pageable);
    List<Product> findAllByStatus(Status status, Sort sort);
    Optional<Product> findByTitle(String name);
}
