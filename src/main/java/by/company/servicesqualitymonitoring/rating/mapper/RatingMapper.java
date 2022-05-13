package by.company.servicesqualitymonitoring.rating.mapper;

import by.company.servicesqualitymonitoring.MonitoringMapper;
import by.company.servicesqualitymonitoring.rating.dto.*;
import by.company.servicesqualitymonitoring.category.CategoryMapper;
import by.company.servicesqualitymonitoring.company.CompanyMapper;
import by.company.servicesqualitymonitoring.rating.Rating;
import by.company.servicesqualitymonitoring.service.OnlineServiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, CompanyMapper.class, OnlineServiceMapper.class})
public interface RatingMapper extends MonitoringMapper<Rating, RatingDto> {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "serviceId", target = "onlineService.id")
    Rating convertDtoToBo(CreateRatingDto dto);
}
