package ru.gb.gbshopmart.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.gb.gbshopmart.entity.enums.Status;
import ru.gb.gbshopmart.web.dto.common.InfoDto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto extends InfoDto {

    @NotBlank
    @JsonProperty(value = "title")
    private String title;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
    private BigDecimal cost;
    @PastOrPresent
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate manufactureDate;
    @NotNull
    private Status status;
    private String manufacturer;

    @Builder
    public ProductDto(Long id, String version, String created_by, LocalDateTime created_date, String last_modified_by, LocalDateTime last_modified_date, String title, BigDecimal cost, LocalDate manufactureDate, Status status, String manufacturer) {
        super(id, version, created_by, created_date, last_modified_by, last_modified_date);
        this.title = title;
        this.cost = cost;
        this.manufactureDate = manufactureDate;
        this.status = status;
        this.manufacturer = manufacturer;
    }

    @Builder
    public ProductDto(Long id, String title, BigDecimal cost, LocalDate manufactureDate, Status status, String manufacturer) {
        super(id);
        this.title = title;
        this.cost = cost;
        this.manufactureDate = manufactureDate;
        this.status = status;
        this.manufacturer = manufacturer;
    }
}
