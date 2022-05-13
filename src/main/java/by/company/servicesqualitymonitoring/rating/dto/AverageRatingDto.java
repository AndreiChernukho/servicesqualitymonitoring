package by.company.servicesqualitymonitoring.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AverageRatingDto {

    String serviceName;
    Integer averageRating;
    Integer count;
}
