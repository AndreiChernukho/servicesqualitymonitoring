package by.company.servicesqualitymonitoring.report;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class WordService implements ReportService<Object> {

    public Resource generate(List<List<Object>> rows, String title) {
        if (rows == null || rows.isEmpty()) {
            return null;
        }
        Resource resource = null;
        try (XWPFDocument document = new XWPFDocument(); ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun titleRun = paragraph.createRun();
            titleRun.setText(title);
            titleRun.setColor("000000");
            titleRun.setBold(true);
            titleRun.setFontFamily("Courier");
            titleRun.setFontSize(20);

            XWPFTable table = document.createTable(rows.size(), rows.get(0).size());

            for (int i = 0; i < rows.size(); i++) {
                XWPFTableRow row = table.getRow(i);
                List<Object> item = rows.get(i);
                for (int j = 0; j < item.size(); j++) {
                    XWPFTableCell cell = row.getCell(j);
                    if (i == 0) {
                        cell.setColor("DCDCDC");
                    }
                    cell.setText(Objects.toString(item.get(j)));
                }
            }

            document.write(stream);
            resource = new ByteArrayResource(stream.toByteArray());
        } catch (IOException e) {
            log.error("Ошибка генерации файла", e);
        }
        return resource;
    }
}
