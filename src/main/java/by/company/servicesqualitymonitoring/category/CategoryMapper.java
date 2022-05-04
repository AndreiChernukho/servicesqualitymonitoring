package by.company.servicesqualitymonitoring.category;

import by.company.servicesqualitymonitoring.MonitoringMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends MonitoringMapper<Category, CategoryDto> {
}
