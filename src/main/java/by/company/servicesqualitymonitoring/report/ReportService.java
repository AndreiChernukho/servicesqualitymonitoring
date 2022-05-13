package by.company.servicesqualitymonitoring.report;

import java.util.List;
import org.springframework.core.io.Resource;

public interface ReportService<T> {

  Resource generate(List<List<T>> rows, String title);
}
