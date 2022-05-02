package by.company.servicesqualitymonitoring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServiceService {

    public final ServiceRepository serviceRepository;

    public by.company.servicesqualitymonitoring.service.Service get(Long id) {
        return serviceRepository.getById(id);
    }

    public List<by.company.servicesqualitymonitoring.service.Service> getAll() {
        return serviceRepository.findAll();
    }
}
