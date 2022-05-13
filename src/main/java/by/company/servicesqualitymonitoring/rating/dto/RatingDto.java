package by.company.servicesqualitymonitoring.rating.dto;

import by.company.servicesqualitymonitoring.category.CategoryDto;
import by.company.servicesqualitymonitoring.company.CompanyDto;
import by.company.servicesqualitymonitoring.service.OnlineServiceDto;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
public class RatingDto {

    private Long id;
    private Integer rating;
    private CategoryDto category;
    private CompanyDto company;
    private OnlineServiceDto onlineService;
    private String comment;
    private LocalDateTime creationDate;
}
