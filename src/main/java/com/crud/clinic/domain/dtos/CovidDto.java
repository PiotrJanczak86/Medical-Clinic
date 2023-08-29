package com.crud.clinic.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidDto {
    private Long deaths;
    private Long cases;
    private Long critical;

}
