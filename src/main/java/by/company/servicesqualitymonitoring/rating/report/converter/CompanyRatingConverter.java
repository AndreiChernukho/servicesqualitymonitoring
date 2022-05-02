package by.company.servicesqualitymonitoring.rating.report.converter;

import by.company.servicesqualitymonitoring.rating.model.CompanyRating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyRatingConverter implements Converter<List<CompanyRating>, List<List<Object>>> {

    @Override
    public List<List<Object>> convert(List<CompanyRating> ratings) {
        List<Object> headers = List.of("Госорган", "Оценка", "Количество оценок");
        List<List<Object>> result = new ArrayList<>();
        result.add(headers);
        ratings.forEach(orgRating -> {
            List<Object> row = List.of(
                    orgRating.getCompanyName(),
                    orgRating.getAverageRating(),
                    orgRating.getCount());
            result.add(row);
        });
        return result;
    }
}
