package ru.gb.gbexternalapi.web.dto.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class InfoDto extends BaseDto{

    @JsonProperty(value = "version")
    private String version;
    @JsonProperty(value = "created_by")
    private String created_by;
    @JsonProperty(value = "created_date")
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDateTime created_date;
    @JsonProperty(value = "last_modified_by")
    private String last_modified_by;
    @JsonProperty(value = "last_modified_date")
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDateTime last_modified_date;

    public InfoDto(Long id, String version, String created_by, LocalDateTime created_date, String last_modified_by, LocalDateTime last_modified_date) {
        super(id);
        this.version = version;
        this.created_by = created_by;
        this.created_date = created_date;
        this.last_modified_by = last_modified_by;
        this.last_modified_date = last_modified_date;
    }

    public InfoDto(Long id) {
        super(id);
    }
}
