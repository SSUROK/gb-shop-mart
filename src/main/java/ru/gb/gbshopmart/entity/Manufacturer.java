package ru.gb.gbshopmart.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gb.gbshopmart.entity.common.InfoEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "MANUFACTURER")
@EntityListeners(AuditingEntityListener.class)
public class Manufacturer extends InfoEntity {

    @Column(name = "name")
    private String title;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.MERGE)
    private Set<Product> products;

    public boolean addProduct(Product product) {
        if (products == null) {
            products = new HashSet<>();
        }
        return products.add(product);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + getId() +
                ", name='" + title + '\'' +
                ", products=" + products +
                '}';
    }

    @Builder
    public Manufacturer(Long id, int version, String createdBy, LocalDateTime createdDate, String lastModifiedBy,
                        LocalDateTime lastModifiedDate, String title, Set<Product> products) {
        super(id, version, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.title = title;
        this.products = products;
    }
}
