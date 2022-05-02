package by.company.servicesqualitymonitoring.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyRating {

    private String companyName;
    private Integer averageRating;
    private Integer count;
}
