package by.company.servicesqualitymonitoring.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.YearMonth;

@Data
@AllArgsConstructor
public class DynamicsDto {

   private YearMonth yearMonth;
   private Integer averageRating;
}
