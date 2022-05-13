package by.company.servicesqualitymonitoring.company;

import by.company.servicesqualitymonitoring.MonitoringMapper;
import org.mapstruct.Mapper;;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends MonitoringMapper<Company, CompanyDto> {
}
