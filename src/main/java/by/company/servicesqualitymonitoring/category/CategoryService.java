package by.company.servicesqualitymonitoring.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryService {

    public final CategoryRepository categoryRepository;

    public Category get(Long id) {
        return categoryRepository.getById(id);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
