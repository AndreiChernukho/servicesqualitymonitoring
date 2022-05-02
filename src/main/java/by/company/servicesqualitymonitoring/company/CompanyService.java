package by.company.servicesqualitymonitoring.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyService {

    public final CompanyRepository companyRepository;

    @Transactional
    public void save(Company company) {
        Company current = company.getId() != null ? companyRepository.getById(company.getId()) : company;
        current.setName(company.getName());
        current.setUnn(company.getUnn());
        companyRepository.save(current);
    }

    public Company get(Long id) {
        return companyRepository.getById(id);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
