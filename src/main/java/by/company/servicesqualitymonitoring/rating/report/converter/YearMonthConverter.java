package by.company.servicesqualitymonitoring.rating.report.converter;

import org.springframework.stereotype.Component;

import java.time.Month;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

@Component
public class YearMonthConverter implements Converter<YearMonth, String> {

    private final static Map<Month, String> MONTH_CONVERTER = new HashMap<>();

    static {
        MONTH_CONVERTER.put(Month.JANUARY, "Январь");
        MONTH_CONVERTER.put(Month.FEBRUARY, "Февраль");
        MONTH_CONVERTER.put(Month.MARCH, "Март");
        MONTH_CONVERTER.put(Month.APRIL, "Апрель");
        MONTH_CONVERTER.put(Month.MAY, "Май");
        MONTH_CONVERTER.put(Month.JUNE, "Июнь");
        MONTH_CONVERTER.put(Month.JULY, "Июль");
        MONTH_CONVERTER.put(Month.AUGUST, "Август");
        MONTH_CONVERTER.put(Month.SEPTEMBER, "Сентябрь");
        MONTH_CONVERTER.put(Month.OCTOBER, "Октябрь");
        MONTH_CONVERTER.put(Month.NOVEMBER, "Ноябрь");
        MONTH_CONVERTER.put(Month.DECEMBER, "Декабрь");
    }

    @Override
    public String convert(YearMonth value) {
        return MONTH_CONVERTER.get(value.getMonth()) + " " + value.getYear();
    }
}
