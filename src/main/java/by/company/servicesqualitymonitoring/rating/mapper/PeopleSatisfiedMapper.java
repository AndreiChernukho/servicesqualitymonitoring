package by.company.servicesqualitymonitoring.rating.mapper;

import by.company.servicesqualitymonitoring.MonitoringMapper;
import by.company.servicesqualitymonitoring.rating.dto.*;
import by.company.servicesqualitymonitoring.rating.model.*;

@org.mapstruct.Mapper(componentModel = "spring")
public interface PeopleSatisfiedMapper extends MonitoringMapper<PeopleSatisfied, PeopleSatisfiedDto> {
}
