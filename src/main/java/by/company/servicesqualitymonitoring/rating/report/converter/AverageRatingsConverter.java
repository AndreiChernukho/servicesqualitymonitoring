package by.company.servicesqualitymonitoring.rating.report.converter;

import by.company.servicesqualitymonitoring.rating.model.AverageRating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AverageRatingsConverter implements Converter<List<AverageRating>, List<List<Object>>> {

    @Override
    public List<List<Object>> convert(List<AverageRating> averageRatings) {
        List<Object> headers = List.of("Услуга", "Оценки", "Количество");
        List<List<Object>> result = new ArrayList<>();
        result.add(headers);
        averageRatings.forEach(averageRating -> {
            List<Object> row = List.of(
                    averageRating.getServiceName(),
                    averageRating.getAverageRating(),
                    averageRating.getCount());
            result.add(row);
        });
        return result;
    }
}
