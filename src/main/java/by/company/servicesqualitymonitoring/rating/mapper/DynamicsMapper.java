package by.company.servicesqualitymonitoring.rating.mapper;

import by.company.servicesqualitymonitoring.MonitoringMapper;
import by.company.servicesqualitymonitoring.rating.dto.DynamicsDto;
import by.company.servicesqualitymonitoring.rating.model.Dynamics;

@org.mapstruct.Mapper(componentModel = "spring")
public interface DynamicsMapper extends MonitoringMapper<Dynamics, DynamicsDto> {
}
