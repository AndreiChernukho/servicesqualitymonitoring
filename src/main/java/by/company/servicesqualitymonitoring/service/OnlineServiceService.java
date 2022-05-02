package by.company.servicesqualitymonitoring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OnlineServiceService {

    public final OnlineServiceRepository onlineServiceRepository;

    public OnlineService get(Long id) {
        return onlineServiceRepository.getById(id);
    }

    public List<OnlineService> getAll() {
        return onlineServiceRepository.findAll();
    }
}
