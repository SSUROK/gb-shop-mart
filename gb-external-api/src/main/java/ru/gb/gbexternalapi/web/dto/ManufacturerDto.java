package ru.gb.gbexternalapi.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gb.gbexternalapi.web.dto.common.InfoDto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ManufacturerDto extends InfoDto {

    @NotBlank
    @JsonProperty(value = "title")
    private String title;

    @Builder
    public ManufacturerDto(Long id, String version, String created_by, LocalDateTime created_date, String last_modified_by, LocalDateTime last_modified_date, String title) {
        super(id, version, created_by, created_date, last_modified_by, last_modified_date);
        this.title = title;
    }

    @Builder
    public ManufacturerDto(Long id, String title) {
        super(id);
        this.title = title;
    }
}
