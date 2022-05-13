package by.company.servicesqualitymonitoring.rating.report.converter;

import by.company.servicesqualitymonitoring.rating.model.PeopleCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PeopleCountConverter implements Converter<List<PeopleCount>, List<List<Object>>> {

    @Override
    public List<List<Object>> convert(List<PeopleCount> peopleCounts) {
        List<Object> headers = List.of("Услуга", "Количество граждан");
        List<List<Object>> result = new ArrayList<>();
        result.add(headers);
        peopleCounts.forEach(peopleCount -> {
            List<Object> row = List.of(peopleCount.getServiceName(), peopleCount.getCount());
            result.add(row);
        });
        return result;
    }
}
