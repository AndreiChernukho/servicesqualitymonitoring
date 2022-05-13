package by.company.servicesqualitymonitoring.rating.mapper;

import by.company.servicesqualitymonitoring.MonitoringMapper;
import by.company.servicesqualitymonitoring.rating.dto.*;
import by.company.servicesqualitymonitoring.rating.model.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AverageRatingMapper extends MonitoringMapper<AverageRating, AverageRatingDto> {
}
