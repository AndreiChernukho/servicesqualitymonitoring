package by.company.servicesqualitymonitoring.rating.report.converter;

import by.company.servicesqualitymonitoring.rating.model.PeopleSatisfied;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PeopleSatisfiedConverter implements Converter<List<PeopleSatisfied>, List<List<Object>>> {

    private final static Map<Integer, String> RATING_CONVERTER =
            Map.of(
                    1, "Отлично",
                    0, "Хорошо",
                    -1, "Неудовлетворительно");

    @Override
    public List<List<Object>> convert(List<PeopleSatisfied> peopleSatisfied) {

        List<Object> headers = List.of("Оценка", "Количество граждан");
        List<List<Object>> result = new ArrayList<>();
        result.add(headers);

        peopleSatisfied.forEach(rating -> {
            List<Object> row = List.of(RATING_CONVERTER.get(rating.getRating()), rating.getCountPeople());
            result.add(row);
        });
        return result;
    }
}
