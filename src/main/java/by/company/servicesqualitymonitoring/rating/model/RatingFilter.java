package by.company.servicesqualitymonitoring.rating.model;

import lombok.Data;

import java.util.List;

@Data
public class RatingFilter {

    public List<Long> categoryIds;
    private List<String> serviceCodes;
    private List<String> categoryNames;
    private List<String> unns;
}
