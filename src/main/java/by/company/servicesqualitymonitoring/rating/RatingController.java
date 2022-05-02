package by.company.servicesqualitymonitoring.rating;

import by.company.servicesqualitymonitoring.category.CategoryMapper;
import by.company.servicesqualitymonitoring.category.CategoryService;
import by.company.servicesqualitymonitoring.company.CompanyMapper;
import by.company.servicesqualitymonitoring.company.CompanyService;
import by.company.servicesqualitymonitoring.rating.dto.*;
import by.company.servicesqualitymonitoring.rating.mapper.RatingMapper;
import by.company.servicesqualitymonitoring.service.ServiceMapper;
import by.company.servicesqualitymonitoring.service.ServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/rating")
public class RatingController {

    private final static Map<Integer, String> RATING_VALUES = Map.of(
            1, "Хорошо",
            0, "Удовлетворительно",
            -1, "Плохо");

    private final RatingService ratingService;
    private final CategoryService categoryService;
    private final CompanyService companyService;
    private final ServiceService serviceService;
    private final RatingMapper ratingMapper;
    private final CategoryMapper categoryMapper;
    private final CompanyMapper companyMapper;
    private final ServiceMapper serviceMapper;

    @GetMapping
    public ModelAndView getAll() {
        log.info("Get '/'");
        ModelAndView modelAndView = new ModelAndView("ratings");
        List<Rating> ratings = ratingService.getAll();
        modelAndView.addObject("ratings", ratingMapper.convert(ratings));
        modelAndView.addObject("ratingValues", RATING_VALUES);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") Long id) {
        log.info("Post '/{}'", id);
        ModelAndView modelAndView = new ModelAndView("rating");
        Rating rating = ratingService.get(id);
        modelAndView.addObject("ratingValues", RATING_VALUES);
        modelAndView.addObject("rating", ratingMapper.convert(rating));
        modelAndView.addObject("categories", categoryMapper.convert(categoryService.getAll()));
        modelAndView.addObject("companies", companyMapper.convert(companyService.getAll()));
        modelAndView.addObject("services", serviceMapper.convert(serviceService.getAll()));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("rating");
        modelAndView.addObject("ratingValues", RATING_VALUES);
        modelAndView.addObject("categories", categoryMapper.convert(categoryService.getAll()));
        modelAndView.addObject("companies", companyMapper.convert(companyService.getAll()));
        modelAndView.addObject("services", serviceMapper.convert(serviceService.getAll()));
        return modelAndView;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView create(@Valid CreateRatingDto createRatingDto) {
        log.info("Post '/' request body: {}", createRatingDto);
        ratingService.save(ratingMapper.convert(createRatingDto));
        return getAll();
    }

    @PostMapping("/edit")
    public ModelAndView edit(@RequestBody @Valid CreateRatingDto createRatingDto) {
        log.info("Put '/' request body: {}", createRatingDto);
        ratingService.save(ratingMapper.convert(createRatingDto));
        return getAll();
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        log.info("Post '/ {}' ", id);
        ratingService.delete(id);
        return getAll();
    }

//    @PostMapping("/average")
//    public List<AverageRatingDto> getAverageRatings(
//            @RequestBody(required = false) @Valid RatingFilterDto filterDto) {
//
//        log.info("Post '/average' request body: {}", filterDto);
//        List<AverageRating> averageRatings = ratingService.getAverageRatings(ratingMapper.convertFilter(filterDto));
//        return ratingMapper.convertAverageRating(averageRatings);
//    }
//
//    @GetMapping("/people/count")
//    public List<PeopleCountDto> getPeopleCount() {
//        log.info("Get '/people/count'");
//        return ratingMapper.convertPeopleCount(ratingService.getPeopleCount());
//    }
//
//    @PostMapping("/people/satisfied")
//    public List<PeopleSatisfiedDto> getPeopleSatisfied(
//            @RequestBody(required = false) @Valid RatingFilterDto filterDto) {
//
//        log.info("Post '/people/satisfied' request body: {}", filterDto);
//        List<PeopleSatisfied> peopleSatisfied =
//                ratingService.getPeopleSatisfied(ratingMapper.convertFilter(filterDto));
//        return ratingMapper.convertPeopleSatisfied(peopleSatisfied);
//    }
//
//    @PostMapping("/dynamics")
//    public List<DynamicsDto> getDynamics(@RequestBody RatingFilterDto filterDto) {
//        log.info("Post '/dynamics' request body: {}", filterDto);
//        List<Dynamics> ratings = ratingService.getDynamics(ratingMapper.convertFilter(filterDto));
//        return ratingMapper.convertDynamics(ratings);
//    }
}
