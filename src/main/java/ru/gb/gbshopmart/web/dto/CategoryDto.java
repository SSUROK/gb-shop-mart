package ru.gb.gbshopmart.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.gb.gbshopmart.web.dto.common.InfoDto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto extends InfoDto {

    @NotBlank
    @JsonProperty(value = "title")
    private String title;

    @Builder
    public CategoryDto(Long id, String version, String created_by, LocalDateTime created_date, String last_modified_by, LocalDateTime last_modified_date, String title) {
        super(id, version, created_by, created_date, last_modified_by, last_modified_date);
        this.title = title;
    }
}
