package by.company.servicesqualitymonitoring.rating.mapper;

import by.company.servicesqualitymonitoring.MonitoringMapper;
import by.company.servicesqualitymonitoring.rating.dto.RatingFilterDto;
import by.company.servicesqualitymonitoring.rating.model.RatingFilter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingFilterMapper extends MonitoringMapper<RatingFilter, RatingFilterDto> {
}
