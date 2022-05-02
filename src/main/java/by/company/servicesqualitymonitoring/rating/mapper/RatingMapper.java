package by.company.servicesqualitymonitoring.rating.mapper;

import by.company.servicesqualitymonitoring.rating.dto.*;
import by.company.servicesqualitymonitoring.rating.model.*;
import by.company.servicesqualitymonitoring.category.CategoryMapper;
import by.company.servicesqualitymonitoring.company.CompanyMapper;
import by.company.servicesqualitymonitoring.rating.Rating;
import by.company.servicesqualitymonitoring.service.ServiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, CompanyMapper.class, ServiceMapper.class})
public interface RatingMapper {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "serviceId", target = "service.id")
    Rating convert(CreateRatingDto createRatingDto);

    RatingDto convert(Rating rating);
    List<RatingDto> convert(List<Rating> ratings);

    AverageRatingDto convertAverageRating(AverageRating averageRating);
    List<AverageRatingDto> convertAverageRating(List<AverageRating> averageRatingList);

    PeopleSatisfiedDto convertPeopleSatisfied(PeopleSatisfied peopleSatisfied);
    List<PeopleSatisfiedDto> convertPeopleSatisfied(List<PeopleSatisfied> peopleSatisfiedList);

    PeopleCountDto convertPeopleCount(PeopleCount peopleCount);
    List<PeopleCountDto> convertPeopleCount(List<PeopleCount> peopleCountList);

    DynamicsDto convertDynamics(Dynamics dynamics);
    List<DynamicsDto> convertDynamics(List<Dynamics> dynamicsList);

    RatingFilter convertFilter(RatingFilterDto filterDto);
}
