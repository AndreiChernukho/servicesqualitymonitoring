package by.company.servicesqualitymonitoring.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @GetMapping
    public ModelAndView getAll() {
        log.info("Get '/'");
        ModelAndView modelAndView = new ModelAndView("companies");
        List<Company> companies = companyService.getAll();
        modelAndView.addObject("companies", companyMapper.convertBoToDto(companies));
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") Long id) {
        log.info("Post '/{}'", id);
        ModelAndView modelAndView = new ModelAndView("company");
        Company company = companyService.get(id);
        modelAndView.addObject("company", companyMapper.convertBoToDto(company));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("company");
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView create(@Valid CompanyDto companyDto) {
        log.info("Post '/' request body: {}", companyDto);
        companyService.save(companyMapper.convertDtoToBo(companyDto));
        return new ModelAndView("redirect:/company");
    }

    @PostMapping("/edit")
    public ModelAndView edit(@RequestBody @Valid CompanyDto companyDto) {
        log.info("Put '/' request body: {}", companyDto);
        companyService.save(companyMapper.convertDtoToBo(companyDto));
        return new ModelAndView("redirect:/company");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        log.info("Post '/ {}' ", id);
        companyService.delete(id);
        return new ModelAndView("redirect:/company");
    }
}
