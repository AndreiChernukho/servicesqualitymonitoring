package by.company.servicesqualitymonitoring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineServiceRepository extends JpaRepository<OnlineService, Long> {
}
