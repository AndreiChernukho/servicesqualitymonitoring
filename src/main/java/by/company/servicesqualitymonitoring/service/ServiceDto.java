package by.company.servicesqualitymonitoring.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceDto {

    private Long id;
    private String name;
    private String code;
}
