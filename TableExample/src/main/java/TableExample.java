package main.java;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfXrefTable;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import sun.font.FontFamily;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableExample {

    public static void main(String[] args) throws FileNotFoundException {

//         PDF Writer
        String path = "F:\\Learning Java\\IText Pdf\\sample2.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);

//         Pdf Doc
        PdfDocument pdfDoc = new PdfDocument(pdfWriter);
        Document doc = new Document(pdfDoc);
        PdfPage page = pdfDoc.addNewPage();
        System.out.println(page.getPageSize());
//        PageSize size = new PageSize(619, 792);
//        pdfDoc.setDefaultPageSize(size);
//        PdfPage canvaPage = pdfDoc.addNewPage();
//        PdfCanvas canvas = new PdfCanvas(canvaPage);
//        for (float x = 0; x <= size.getWidth(); x += 50f ){
//            for (float y = 0; y <= size.getHeight(); y += 50f){
//                canvas.circle(x,y,1f);
//            }
//        }
//        canvas.fill();
//        pdfDoc.addPage(canvaPage);
//        pdfDoc.close();

//        Doc
        // Canvas
        PdfCanvas canvas = new PdfCanvas(page);
        canvas.setColor(new DeviceRgb(51, 204, 51), true);
        canvas.circle(0, 830, 200);
        canvas.fill();

        PdfCanvas circle = new PdfCanvas(page);
        circle.setColor(new DeviceRgb(0, 102, 0), false);
        circle.circle(10, 842, 300);
        canvas.fill();

        // Table
        Table table = new Table(4);
        table.useAllAvailableWidth();

        Cell cell = new Cell(1, 4);
        cell.add(new Paragraph("Payslip"));
        cell.setFontColor(new DeviceRgb(0, 102, 0));
        cell.setFontSize(30);
        cell.setBold();
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.RIGHT);
        cell.setPaddingRight(10);
        table.addCell(cell);

        cell = new Cell(1, 4);
        cell.add(new Paragraph("Payslip For the Month of February"));
        cell.setFontSize(13);
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.RIGHT);
        table.addCell(cell);
//        cell = new Cell(1,1);
//        cell.add(new Paragraph("Name :"));
//        cell.setFontSize(10);
//        cell.setBold();
//        cell.setBackgroundColor(new DeviceRgb(153, 204, 255));
//        cell.setTextAlignment(TextAlignment.CENTER);
//        table.addCell(cell);
//
//        cell=new Cell(1,1);
//        cell.add(new Paragraph("Rajan"));
//        cell.setFontSize(10);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        table.addCell(cell);
//
//        cell=new Cell(1,1);
//        cell.add(new Paragraph(""));
//        cell.setFontSize(10);
//        cell.setBorder(Border.NO_BORDER);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        table.addCell(cell);
//
//        cell=new Cell(1,1);
//        cell.add(new Paragraph("Cell"));
//        cell.setFontSize(10);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        table.addCell(cell);
//        cell=new Cell(1,1);
//        cell.add(new Paragraph("Cell"));
//        cell.setFontSize(10);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        table.addCell(cell);
//
//        cell=new Cell(1,1);
//        cell.add(new Paragraph("Cell"));
//        cell.setFontSize(10);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        table.addCell(cell);
//
//        cell=new Cell(1,1);
//        cell.add(new Paragraph("Cell"));
//        cell.setFontSize(10);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        table.addCell(cell);
//
//        cell=new Cell(1,1);
//        cell.add(new Paragraph("Cell"));
//        cell.setFontSize(10);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        table.addCell(cell);
        doc.add(table);
        doc.close();
    }

    public static List<Map<String, Object>> getStudents() {
        List<Map<String, Object>> students = new ArrayList<>();
        Map<String, Object> ramKumar = new HashMap<>();
        ramKumar.put("name", "Ram Kumar");
        ramKumar.put("class", "10th");
        ramKumar.put("father_name", "Pawan Kumar");

        Map<String, Object> pawanKumar = new HashMap<>();
        pawanKumar.put("name", "Pawan Kumar");
        pawanKumar.put("class", "10th");
        pawanKumar.put("father_name", "Subhash Kumar");

        students.add(pawanKumar);
        return students;
    }
}


