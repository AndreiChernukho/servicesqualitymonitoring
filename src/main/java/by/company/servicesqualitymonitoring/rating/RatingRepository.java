package by.company.servicesqualitymonitoring.rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT rating FROM Rating rating " +
            "WHERE (:serviceCodes IS NULL OR rating.service.code IN(:serviceCodes)) " +
            "AND (:categoryIds IS NULL OR rating.category.id IN(:categoryIds)) " +
            "AND (:categoryNames IS NULL OR rating.category.name IN(:categoryNames)) " +
            "AND (:unns IS NULL OR rating.company.unn IN(:unns))")
    List<Rating> findByFilter(
            List<String> serviceCodes, Collection<Long> categoryIds, List<String> unns, List<String> categoryNames);
}
