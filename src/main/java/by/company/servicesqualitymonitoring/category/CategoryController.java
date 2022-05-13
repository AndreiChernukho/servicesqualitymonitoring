package by.company.servicesqualitymonitoring.category;

import java.util.List;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ModelAndView getAll() {
        log.info("Get '/'");
        ModelAndView modelAndView = new ModelAndView("categories");
        List<Category> categories = categoryService.getAll();
        modelAndView.addObject("categories", categoryMapper.convertBoToDto(categories));
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") Long id) {
        log.info("Post '/{}'", id);
        ModelAndView modelAndView = new ModelAndView("category");
        Category category = categoryService.get(id);
        modelAndView.addObject("category", categoryMapper.convertBoToDto(category));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("category");
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView create(@Valid CategoryDto categoryDto) {
        log.info("Post '/' request body: {}", categoryDto);
        categoryService.save(categoryMapper.convertDtoToBo(categoryDto));
        return new ModelAndView("redirect:/category");
    }

    @PostMapping("/edit")
    public ModelAndView edit(@RequestBody @Valid CategoryDto categoryDto) {
        log.info("Put '/' request body: {}", categoryDto);
        categoryService.save(categoryMapper.convertDtoToBo(categoryDto));
        return new ModelAndView("redirect:/category");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        log.info("Post '/ {}' ", id);
        categoryService.delete(id);
        return new ModelAndView("redirect:/category");
    }
}
