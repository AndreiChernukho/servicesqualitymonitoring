package by.company.servicesqualitymonitoring.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.YearMonth;

@Data
@AllArgsConstructor
public class Dynamics {

   private YearMonth yearMonth;
   private Integer averageRating;
}
