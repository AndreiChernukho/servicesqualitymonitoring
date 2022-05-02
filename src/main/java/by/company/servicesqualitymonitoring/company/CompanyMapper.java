package by.company.servicesqualitymonitoring.company;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company convert(CompanyDto companyDto);
    CompanyDto convert(Company company);
    List<CompanyDto> convert(List<Company> service);
}
