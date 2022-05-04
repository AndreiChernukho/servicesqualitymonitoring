package by.company.servicesqualitymonitoring;

import java.util.List;

public interface MonitoringMapper<T, D> {

    D convertBoToDto(T obj);
    List<D> convertBoToDto(List<T> ratings);
    T convertDtoToBo(D dto);
}
