package by.company.servicesqualitymonitoring.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeopleCountDto {

    private String serviceName;
    private Integer count;
}
