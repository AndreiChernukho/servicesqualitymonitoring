package by.company.servicesqualitymonitoring.service;

import by.company.servicesqualitymonitoring.MonitoringMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OnlineServiceMapper extends MonitoringMapper<OnlineService, OnlineServiceDto> {
}
