package by.company.servicesqualitymonitoring.rating.report.converter;

import by.company.servicesqualitymonitoring.rating.model.Dynamics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DynamicsConverter implements Converter<List<Dynamics>, List<List<Object>>> {

    public final YearMonthConverter yearMonthConverter;

    @Override
    public List<List<Object>> convert(List<Dynamics> dynamicsList) {
        List<Object> headers = List.of("Дата", "Оценка");
        List<List<Object>> result = new ArrayList<>();
        result.add(headers);
        dynamicsList.forEach(dynamics -> {
            List<Object> row = List.of(
                    yearMonthConverter.convert(dynamics.getYearMonth()),
                    dynamics.getAverageRating());
            result.add(row);
        });
        return result;
    }
}
