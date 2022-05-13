package by.company.servicesqualitymonitoring.rating.report.converter;

public interface Converter<T, E> {

    E convert(T value);
}
