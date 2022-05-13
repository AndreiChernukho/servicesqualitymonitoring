package by.company.servicesqualitymonitoring.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeopleCount {

    private String serviceName;
    private Integer count;
}
