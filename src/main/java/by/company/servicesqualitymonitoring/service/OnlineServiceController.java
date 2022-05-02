package by.company.servicesqualitymonitoring.service;

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
@RequestMapping("/service")
public class OnlineServiceController {

    private final OnlineServiceService onlineServiceService;
    private final OnlineServiceMapper onlineServiceMapper;

    @GetMapping
    public ModelAndView getAll() {
        log.info("Get '/'");
        ModelAndView modelAndView = new ModelAndView("onlineServices");
        List<OnlineService> onlineServices = onlineServiceService.getAll();
        modelAndView.addObject("onlineServices", onlineServiceMapper.convert(onlineServices));
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") Long id) {
        log.info("Post '/{}'", id);
        ModelAndView modelAndView = new ModelAndView("onlineService");
        OnlineService onlineService = onlineServiceService.get(id);
        modelAndView.addObject("onlineService", onlineServiceMapper.convert(onlineService));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("onlineService");
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView create(@Valid OnlineServiceDto onlineServiceDto) {
        log.info("Post '/' request body: {}", onlineServiceDto);
        onlineServiceService.save(onlineServiceMapper.convert(onlineServiceDto));
        return getAll();
    }

    @PostMapping("/edit")
    public ModelAndView edit(@RequestBody @Valid OnlineServiceDto onlineServiceDto) {
        log.info("Put '/' request body: {}", onlineServiceDto);
        onlineServiceService.save(onlineServiceMapper.convert(onlineServiceDto));
        return getAll();
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        log.info("Post '/ {}' ", id);
        onlineServiceService.delete(id);
        return getAll();
    }
}
