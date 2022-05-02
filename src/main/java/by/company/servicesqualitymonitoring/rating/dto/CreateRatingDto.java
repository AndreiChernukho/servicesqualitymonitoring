package by.company.servicesqualitymonitoring.rating.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;

@ToString
@Data
public class CreateRatingDto {

    private Integer id;

    @Min(value = -1,message = "Минимальное целое значение для поля 'value': -1")
    @Max(value = 1, message = "Максимальное целое значение для поля 'value': 1")
    private Integer rating;

    private Long categoryId;

    private Long companyId;

    private Long serviceId;

    private String comment;
}
