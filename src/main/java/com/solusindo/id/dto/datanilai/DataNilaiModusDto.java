package com.solusindo.id.dto.datanilai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
public class DataNilaiModusDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -4419531611761094688L;

    private String emotion;
    private Long count;

    public DataNilaiModusDto(String emotion, Long count) {
        this.emotion = emotion;
        this.count = count;
    }
}
