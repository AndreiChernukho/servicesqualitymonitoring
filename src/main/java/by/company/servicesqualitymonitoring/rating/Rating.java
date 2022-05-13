package by.company.servicesqualitymonitoring.rating;

import by.company.servicesqualitymonitoring.company.Company;
import by.company.servicesqualitymonitoring.category.Category;
import by.company.servicesqualitymonitoring.service.OnlineService;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Data
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial")
    private Long id;
    private String comment;
    private Integer rating;
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne
    private OnlineService onlineService;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Company company;
}
