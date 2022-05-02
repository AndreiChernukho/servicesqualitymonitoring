package by.company.servicesqualitymonitoring.report;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ExelService implements ReportService<Object> {

    @Override
    public Resource generate(List<List<Object>> rows, String title) {
        Resource resource = null;
        try (SXSSFWorkbook workbook = new SXSSFWorkbook();
             ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            SXSSFSheet sheet = workbook.createSheet();
            sheet.setRandomAccessWindowSize(100);

            for (int i = 0; i < rows.size(); i++) {
                SXSSFRow row = sheet.createRow(i);
                List<Object> item = rows.get(i);
                for (int j = 0; j < item.size(); j++) {
                    row.createCell(j).setCellValue(Objects.toString(item.get(j)));
                }
            }

            workbook.write(stream);
            resource = new ByteArrayResource(stream.toByteArray());
        } catch (IOException e) {
            log.error("Ошибка генерации файла", e);
        }
        return resource;
    }
}
