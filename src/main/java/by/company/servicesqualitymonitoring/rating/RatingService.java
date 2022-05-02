package by.company.servicesqualitymonitoring.rating;

import by.company.servicesqualitymonitoring.category.CategoryService;
import by.company.servicesqualitymonitoring.company.CompanyService;
import by.company.servicesqualitymonitoring.rating.model.*;
import by.company.servicesqualitymonitoring.rating.mapper.RatingMapper;
import by.company.servicesqualitymonitoring.service.ServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class RatingService {

    public final RatingRepository ratingRepository;
    public final RatingMapper ratingMapper;
    public final CategoryService categoryService;
    public final CompanyService companyService;
    public final ServiceService serviceService;

    @Transactional
    public void save(Rating rating) {
        rating.setCategory(categoryService.get(rating.getCategory().getId()));
        rating.setService(serviceService.get(rating.getService().getId()));
        rating.setCompany(companyService.get(rating.getCompany().getId()));
        if (rating.getId() != null) {
            Rating old = ratingRepository.getById(rating.getId());
            old.setCategory(rating.getCategory());
            old.setService(rating.getService());
            old.setCompany(rating.getCompany());
            old.setRating(rating.getRating());
            old.setComment(rating.getComment());
            ratingRepository.save(old);
        } else {
            ratingRepository.save(rating);
        }
    }

    @Transactional
    public Rating get(Long id) {
        return ratingRepository.getById(id);
    }

    @Transactional
    public void delete(Long id) {
        ratingRepository.deleteById(id);
    }

    @Transactional
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Transactional
    public List<AverageRating> getAverageRatings(RatingFilter filter) {
        Map<String, List<Rating>> ratingMap = findAllBy(filter).stream()
                .collect(Collectors.groupingBy(rating -> rating.getService().getName()));

        List<AverageRating> results = new ArrayList<>();
        ratingMap.forEach((serviceName, ratings) -> {
            int averageRating = calculateAverageRating(ratings);
            AverageRating result = new AverageRating(serviceName, averageRating, ratings.size());
            results.add(result);
        });
        return results;
    }

    @Transactional
    public List<CompanyRating> getCompanyRatings(RatingFilter filter) {
        Map<String, List<Rating>> ratingMap = findAllBy(filter).stream()
                .collect(Collectors.groupingBy(rating -> rating.getCompany().getName()));

        List<CompanyRating> results = new ArrayList<>();
        ratingMap.forEach((companyName, ratings) -> {
            int averageRating = calculateAverageRating(ratings);
            CompanyRating result = new CompanyRating(companyName, averageRating, ratings.size());
            results.add(result);
        });
        return results;
    }

    @Transactional
    public List<PeopleSatisfied> getPeopleSatisfied(RatingFilter filter) {
        Map<Integer, List<Rating>> ratingMap = findAllBy(filter).stream()
                .collect(Collectors.groupingBy(Rating::getRating));

        List<PeopleSatisfied> results = new ArrayList<>();
        ratingMap.forEach((rating, ratings) -> {
            PeopleSatisfied result = new PeopleSatisfied(rating, ratings.size());
            results.add(result);
        });
        results.sort((o1, o2) -> o2.getRating().compareTo(o1.getRating()));
        return results;
    }

    @Transactional
    public List<Dynamics> getDynamics(RatingFilter filter) {
        Map<YearMonth, List<Rating>> ratingMap = findAllBy(filter).stream()
                .collect(Collectors.groupingBy(rating -> {
                    LocalDateTime creationDate = rating.getCreationDate();
                    return YearMonth.of(creationDate.getYear(), creationDate.getMonth());
                }));

        List<Dynamics> results = new ArrayList<>();
        ratingMap.forEach((yearMonth, ratings) -> {
            Dynamics result = new Dynamics(yearMonth, calculateAverageRating(ratings));
            results.add(result);
        });
        results.sort(Comparator.comparing(Dynamics::getYearMonth));
        return results;
    }

    @Transactional
    public List<PeopleCount> getPeopleCount() {
        Map<String, List<Rating>> ratingMap = ratingRepository.findAll().stream()
                .collect(Collectors.groupingBy(rating -> rating.getService().getName()));
        List<PeopleCount> peopleCounts = new ArrayList<>();
        ratingMap.forEach((serviceName, ratings) -> {
            PeopleCount result = new PeopleCount(serviceName, ratings.size());
            peopleCounts.add(result);
        });
        return peopleCounts;
    }

    private int calculateAverageRating(List<Rating> ratings) {
        double averageRating = ratings.stream()
                .mapToInt(Rating::getRating)
                .average()
                .orElse(0);

        return (int) (averageRating * 50 + 50);
    }

    private List<Rating> findAllBy(RatingFilter filter) {
        return filter == null
                ? ratingRepository.findAll()
                : ratingRepository.findByFilter(
                filter.getServiceCodes(), filter.getCategoryIds(), filter.getUnns(), filter.getCategoryNames());
    }
}
