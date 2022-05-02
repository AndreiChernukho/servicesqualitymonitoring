package by.company.servicesqualitymonitoring.service;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OnlineServiceMapper {

    OnlineService convert(OnlineServiceDto onlineServiceDto);

    OnlineServiceDto convert(OnlineService onlineService);

    List<OnlineServiceDto> convert(List<OnlineService> onlineService);
}
