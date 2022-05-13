package by.company.servicesqualitymonitoring.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyRatingDto {

    private String companyName;
    private Integer averageRating;
    private Integer count;
}
