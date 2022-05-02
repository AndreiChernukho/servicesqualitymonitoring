package by.company.servicesqualitymonitoring.service;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigserial")
    private Long id;
    private String name;
    private String code;
}
