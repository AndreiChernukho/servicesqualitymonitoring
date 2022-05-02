package by.company.servicesqualitymonitoring.service;

import by.company.servicesqualitymonitoring.category.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OnlineServiceService {

    public final OnlineServiceRepository onlineServiceRepository;

    @Transactional
    public void save(OnlineService onlineService) {
        OnlineService current = onlineService.getId() != null ? onlineServiceRepository.getById(onlineService.getId()) : onlineService;
        current.setName(onlineService.getName());
        current.setCode(onlineService.getCode());
        onlineServiceRepository.save(current);
    }

    public OnlineService get(Long id) {
        return onlineServiceRepository.getById(id);
    }

    public List<OnlineService> getAll() {
        return onlineServiceRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        onlineServiceRepository.deleteById(id);
    }
}
