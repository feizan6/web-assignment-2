package assignment2.view;
//
import assignment2.model.Item;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Fayzan on 28/04/2017.
 */
public class ExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

        @SuppressWarnings("unchecked")
        List<Item> items = (List<Item>) model.get("items");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("My Shopping List");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);


        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("ItemName");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Quantity");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Item Price");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Total Price");
        header.getCell(4).setCellStyle(style);

        int rowCount = 1;

        for(Item item : items){
            Row userRow =  sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(item.getId());
            userRow.createCell(1).setCellValue(item.getItemName());
            userRow.createCell(2).setCellValue(item.getQuantity());
            userRow.createCell(3).setCellValue(item.getItemPrice());
            userRow.createCell(4).setCellValue(item.getTotalPrice());

        }

    }

}