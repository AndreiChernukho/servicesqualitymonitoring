package by.company.servicesqualitymonitoring.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryService {

    public final CategoryRepository categoryRepository;

    @Transactional
    public void save(Category category) {
        Category current = category.getId() != null ? categoryRepository.getById(category.getId()) : category;
        current.setName(category.getName());
        categoryRepository.save(current);
    }

    public Category get(Long id) {
        return categoryRepository.getById(id);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
