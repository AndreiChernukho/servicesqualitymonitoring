package by.company.servicesqualitymonitoring.rating.mapper;

import by.company.servicesqualitymonitoring.MonitoringMapper;
import by.company.servicesqualitymonitoring.rating.dto.PeopleCountDto;
import by.company.servicesqualitymonitoring.rating.model.PeopleCount;

@org.mapstruct.Mapper(componentModel = "spring")
public interface PeopleCountMapper extends MonitoringMapper<PeopleCount, PeopleCountDto> {
}
