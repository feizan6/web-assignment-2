package assignment2.view;//package assignment2.view;

import assignment2.model.Item;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by Fayzan on 28/04/2017.
 */
public class PdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-pdf-file.pdf\"");

        List<Item> items = (List<Item>) model.get("items");
        document.add(new Paragraph("My shopping list  " + LocalDate.now()));

        PdfPTable table = new PdfPTable(items.stream().findAny().get().getColumnCount());
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(5);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(3);

        // write table header

        cell.setPhrase(new Phrase("Item Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Item Price", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Item Quantity", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("TotalPrice", font));
        table.addCell(cell);


        for(Item item : items){
            table.addCell(item.getItemName());
            table.addCell(String.valueOf(item.getItemPrice()));
            table.addCell(String.valueOf(item.getQuantity()));
            table.addCell(String.valueOf(item.getTotalPrice()));

        }

        document.add(table);
    }
}