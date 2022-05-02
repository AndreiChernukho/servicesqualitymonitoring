package by.company.servicesqualitymonitoring.service;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    Service convert(ServiceDto serviceDto);

    ServiceDto convert(Service service);

    List<ServiceDto> convert(List<Service> service);
}
