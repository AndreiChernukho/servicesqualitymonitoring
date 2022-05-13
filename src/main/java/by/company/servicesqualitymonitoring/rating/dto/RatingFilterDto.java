package by.company.servicesqualitymonitoring.rating.dto;

import lombok.Data;

import java.util.List;

@Data
public class RatingFilterDto {

    public List<Long> categoryIds;
    private List<String> serviceCodes;
    private List<String> categoryNames;
    private List<String> unns;
}
