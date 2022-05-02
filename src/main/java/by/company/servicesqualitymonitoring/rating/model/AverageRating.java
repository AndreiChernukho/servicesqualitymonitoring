package by.company.servicesqualitymonitoring.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AverageRating {

    String serviceName;
    Integer averageRating;
    Integer count;
}
