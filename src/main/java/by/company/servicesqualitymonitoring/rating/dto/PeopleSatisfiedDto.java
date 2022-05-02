package by.company.servicesqualitymonitoring.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeopleSatisfiedDto {

    Integer rating;
    Integer countPeople;
}
