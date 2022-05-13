package by.company.servicesqualitymonitoring.rating.report;

import by.company.servicesqualitymonitoring.rating.RatingService;
import by.company.servicesqualitymonitoring.rating.dto.RatingFilterDto;
import by.company.servicesqualitymonitoring.rating.mapper.RatingFilterMapper;
import by.company.servicesqualitymonitoring.rating.model.*;
import by.company.servicesqualitymonitoring.rating.report.converter.*;
import by.company.servicesqualitymonitoring.report.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rating/doc")
public class RatingWordReportController {

    public final ReportService<Object> wordService;
    private final RatingService ratingService;

    private final AverageRatingsConverter averageRatingsConverter;
    private final PeopleCountConverter peopleCountConverter;
    private final PeopleSatisfiedConverter peopleSatisfiedConverter;
    private final DynamicsConverter dynamicsConverter;
    private final CompanyRatingConverter companyRatingConverter;
    private final RatingFilterMapper ratingFilterMapper;

    @GetMapping
    public ResponseEntity<Resource> getCompanyRating(
            @RequestBody(required = false) @Valid RatingFilterDto filterDto) throws IOException {

        log.info("Get '/company'");
        List<CompanyRating> ratings = ratingService.getCompanyRatings(ratingFilterMapper.convertDtoToBo(filterDto));
        String title = "Оценки государственных органов и организаций";
        Resource resource = wordService.generate(companyRatingConverter.convert(ratings), title);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + title)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping("/average")
    public ResponseEntity<Resource> getAverageRating(
            @RequestBody(required = false) @Valid RatingFilterDto filterDto) throws IOException {

        log.info("Post '/averageRatings' request body: {}", filterDto);
        List<AverageRating> results = ratingService.getAverageRatings(ratingFilterMapper.convertDtoToBo(filterDto));
        String title = "Средние оценки по услугам";
        Resource resource = wordService.generate(averageRatingsConverter.convert(results), title);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + title)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }

    @GetMapping("/people/count")
    public ResponseEntity<Resource> getPeopleCount() throws IOException {
        log.info("Get '/people/count'");
        List<PeopleCount> peopleCounts = ratingService.getPeopleCount();
        String title = "Количество граждан, оценивших качество оказания услуг";
        Resource resource = wordService.generate(peopleCountConverter.convert(peopleCounts), title);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + title)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping("/people/satisfied")
    public ResponseEntity<Resource> getPeopleSatisfied(@RequestBody(required = false)
                                                       @Valid RatingFilterDto filterDto) throws IOException {

        log.info("Post '/people/satisfied' request body: {}", filterDto);
        List<PeopleSatisfied> peopleSatisfied =
                ratingService.getPeopleSatisfied(ratingFilterMapper.convertDtoToBo(filterDto));
        String title = "Удовлетворенность граждан";
        Resource resource = wordService.generate(peopleSatisfiedConverter.convert(peopleSatisfied), title);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + title)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping("/dynamics")
    public ResponseEntity<Resource> getDynamics(
            @RequestBody @Valid RatingFilterDto filterDto) throws IOException {

        log.info("Post '/dynamic' request body: {}", filterDto);
        List<Dynamics> dynamics = ratingService.getDynamics(ratingFilterMapper.convertDtoToBo(filterDto));
        String title = "Динамика изменения оценок";
        Resource resource = wordService.generate(dynamicsConverter.convert(dynamics), title);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + title)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
