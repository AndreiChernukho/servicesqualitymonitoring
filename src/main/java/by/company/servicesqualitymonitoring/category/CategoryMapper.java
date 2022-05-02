package by.company.servicesqualitymonitoring.category;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category convert(CategoryDto categoryDto);
    CategoryDto convert(Category category);
    List<CategoryDto> convert(List<Category> service);
}
