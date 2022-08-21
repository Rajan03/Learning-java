package main.java;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;
import java.util.Calendar;

public class MonthlyReport {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "F:\\Learning Java\\IText Pdf\\MonthlyReport.pdf";

        // Pdf Writer
        PdfWriter pdfWriter = new PdfWriter(path);

        // PDF Doc
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        // Document
        Document document = new Document(pdfDocument, PageSize.A4.rotate(), true);

        Table table = new Table(35);
        table.useAllAvailableWidth();

        createCell(1,35,"STUDENTS MONTHLY REPORT: (2020 Jul)", TextAlignment.CENTER, table);
        createCell(1,35,"LECTURE REPORT (2020 Jul)", TextAlignment.CENTER, table);
        createCell(1,35,"Session (2020)", TextAlignment.CENTER, table);
        createCell(1,35,"Class : 3rd A", TextAlignment.CENTER, table);
        createCell(1,1,"So.No.", TextAlignment.CENTER, table);
        createCell(1,1,"Adm. No.", TextAlignment.CENTER, table);
        createCell(1,1,"Student Name", TextAlignment.CENTER, table);
        createCell(1,1,"Father Name", TextAlignment.CENTER, table);

        document.add(table);
        document.close();
    }

    public static void createCell(int row, int col, String text, TextAlignment alignment, Table table){
        Cell cell = new Cell(row,col);
        cell.add(new Paragraph(text));
        cell.setTextAlignment(alignment);
        table.addCell(cell);
    }

}
