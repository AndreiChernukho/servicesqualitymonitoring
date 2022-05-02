package by.company.servicesqualitymonitoring.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyService {

    public final CompanyRepository companyRepository;

    public Company get(Long id) {
        return companyRepository.getById(id);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
