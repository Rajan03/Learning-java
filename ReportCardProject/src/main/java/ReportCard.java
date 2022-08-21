package main.java;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportCard {

    public static void main(String[] args) throws IOException {
        String path = "F:\\Learning Java\\IText Pdf\\ReportCard.pdf";

        Map<String,String> abilitiesToGrade = new HashMap<>();
        abilitiesToGrade.put("Cooperative", "B");
        abilitiesToGrade.put("Good Listener", "C");
        abilitiesToGrade.put("Punctual and Responsible", "A");
        abilitiesToGrade.put("Neat and Orderly", "B");
        abilitiesToGrade.put("Polite and Kind", "A");

        Map<String,String> SubjectsToGrades = new HashMap<>();
        SubjectsToGrades.put("Computer", "B");
        SubjectsToGrades.put("English", "C");
        SubjectsToGrades.put("History", "A");
        SubjectsToGrades.put("Mathematics", "B");
        SubjectsToGrades.put("Social Studies", "A");

        // Pdf Writer
        PdfWriter pdfWriter = new PdfWriter(path);

        // PDF Doc
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        // Document
        Document document = new Document(pdfDocument);

        //Page Header
        document.add(headerTable());

        // Student data Form
        document.add(detailsTable());

        // Metrics Grades Details
        document.add(metricsTable());

        // Academic and Conduct table
        Table centerTable = new Table(UnitValue.createPercentArray(new float[]{50,50}));
        centerTable.useAllAvailableWidth();
        centerTable.setMarginTop(25);

        Cell cell = new Cell();
        cell.setBorder(Border.NO_BORDER);
        cell.add(AcademicsTables(abilitiesToGrade, "CONDUCT"));
        centerTable.addCell(cell);

        cell = new Cell();
        cell.setBorder(Border.NO_BORDER);
        cell.add(AcademicsTables(SubjectsToGrades, "ACADEMICS"));
        centerTable.addCell(cell);

        document.add(centerTable);

        // Teacher Remarks Table
        Table remarksTable = new Table(1);
        remarksTable.useAllAvailableWidth();
        remarksTable.setMarginTop(30);

        cell = new Cell();
        cell.add(new Paragraph("TEACHER'S REMARKS").setCharacterSpacing(3));
        cell.setBold();
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setTextAlignment(TextAlignment.LEFT);
        cell.setFontColor(new DeviceRgb(23,51,68));
        cell.setBorder(Border.NO_BORDER);
        remarksTable.addCell(cell);

        cell = new Cell();
        cell.setBackgroundColor(new DeviceRgb(218,232,239));
        cell.setBorder(Border.NO_BORDER);
        cell.setHeight(100);
        remarksTable.addCell(cell);

        document.add(remarksTable);

        //Page footer
        Table footer = new Table(1);
        footer.useAllAvailableWidth();
        footer.setMarginRight(-75);
        footer.setFixedPosition(0,0,UnitValue.createPercentValue(100));
        cell = new Cell();
        cell.setBackgroundColor(new DeviceRgb(23,51,68));
        cell.setHeight(10);
        footer.addCell(cell);
        document.add(footer);
        document.close();
    }

    private static Table headerTable() throws MalformedURLException {
        Table header = new Table(UnitValue.createPercentArray(new float[]{30,70}));
        header.useAllAvailableWidth();
        header.setMarginRight(-37);
        header.setMarginLeft(-37);

        Image logo = new Image(ImageDataFactory.create("C:\\Users\\acer\\Desktop\\2.png"));
        logo.setHeight(60);
        logo.setWidth(60);
        logo.setHorizontalAlignment(HorizontalAlignment.CENTER);

        Cell cell = new Cell();
        cell.add(logo);
        cell.setBackgroundColor(new DeviceRgb(23,51,68));
        cell.setBorder(Border.NO_BORDER);
        header.addCell(cell);

        Paragraph title = new Paragraph("REPORT CARD");
        title.setCharacterSpacing(3);
        title.setFontColor(new DeviceRgb(23,51,68));

        cell = new Cell();
        cell.add(title);
        cell.setBold();
        cell.setBackgroundColor(new DeviceRgb(146,188,207));
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setFontSize(24);
        header.addCell(cell);
        return header;
    }

    private static Table detailsTable(){
        Table details = new Table(UnitValue.createPercentArray(new float[]{25,25,25,25}));
        details.useAllAvailableWidth();
        details.setMarginTop(30);
        details.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
        details.setVerticalBorderSpacing(20);
        details.setHorizontalBorderSpacing(5);

        details.addCell(detailCell("Student's Name: ", 0, TextAlignment.RIGHT, VerticalAlignment.TOP));
        details.addCell(detailCell("....................................", 0, TextAlignment.LEFT, VerticalAlignment.BOTTOM));
        details.addCell(detailCell("Class / Section: ", 15, TextAlignment.RIGHT, VerticalAlignment.TOP));
        details.addCell(detailCell("....................................", 0, TextAlignment.LEFT, VerticalAlignment.BOTTOM));
        details.addCell(detailCell("Teacher's Name: ", 0, TextAlignment.RIGHT, VerticalAlignment.TOP));
        details.addCell(detailCell("....................................", 0, TextAlignment.LEFT, VerticalAlignment.BOTTOM));
        details.addCell(detailCell("No. of Sessions: ", 15, TextAlignment.RIGHT, VerticalAlignment.TOP));
        details.addCell(detailCell("....................................", 0, TextAlignment.LEFT, VerticalAlignment.BOTTOM));
        return details;
    }

    private static Cell detailCell(String text, float padding, TextAlignment align, VerticalAlignment verticalAlign){
        Cell cell = new Cell();
        cell.add(new Paragraph(text));
        cell.setVerticalAlignment(verticalAlign);
        cell.setTextAlignment(align);
        cell.setPaddingLeft(padding);
        cell.setFontColor(new DeviceRgb(23,51,68));
        cell.setBorder(Border.NO_BORDER);
        return cell;
    }

    private static Table metricsTable(){
        Table details = new Table(1);
        details.useAllAvailableWidth();
        details.setMarginTop(30);

        Cell cell = new Cell();
        cell.add(new Paragraph("METRICS").setCharacterSpacing(3));
        cell.setBold();
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setTextAlignment(TextAlignment.LEFT);
        cell.setFontColor(new DeviceRgb(23,51,68));
        cell.setBorder(Border.NO_BORDER);
        details.addCell(cell);

        cell = new Cell();
        cell.add(metricGrades());
        cell.setBorder(Border.NO_BORDER);
        details.addCell(cell);

        return details;
    }
    private static Table metricGrades(){
        ArrayList<String> grade =  new ArrayList<String>();
        grade.add("A - Superior");
        grade.add("B - Above Average");
        grade.add("C - Average");
        grade.add("D - Below Avg");
        grade.add("E - Poor");
        grade.add("F - Fail");

        Table details = new Table(UnitValue.createPercentArray(new float[]{50,50}));
        details.useAllAvailableWidth();
        details.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
        details.setVerticalBorderSpacing(0);
        details.setHorizontalBorderSpacing(2);

        for(String eachItem : grade){
            Cell cell = new Cell();
            cell.add(new Paragraph(eachItem));
            cell.setPadding(10);
            cell.setFontSize(10);
            cell.setFontColor(new DeviceRgb(23,51,68));
            cell.setBackgroundColor(new DeviceRgb(218,232,239));
            cell.setBorder(Border.NO_BORDER);
            details.addCell(cell);
        }
        return details;
    }

    private static Table AcademicsTables(Map<String,String> gradingContent, String name){

        Table academicsTables = new Table(UnitValue.createPercentArray(new float[]{70,30}));
        academicsTables.useAllAvailableWidth();
        academicsTables.setMarginTop(40);
        academicsTables.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
        academicsTables.setVerticalBorderSpacing(0);
        academicsTables.setHorizontalBorderSpacing(3);

        Cell cell = new Cell(1,2);
        cell.add(new Paragraph(name).setCharacterSpacing(3));
        cell.setBold();
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setTextAlignment(TextAlignment.LEFT);
        cell.setFontColor(new DeviceRgb(23,51,68));
        cell.setBorder(Border.NO_BORDER);
        academicsTables.addCell(cell);

        gradingContent.forEach((mapKey, mapValue) -> {
            academicData(academicsTables, mapKey);
            academicData(academicsTables, mapValue);
        });
        return academicsTables;
    }
    private static void academicData(Table academicsTables, String keysValues) {
        Cell cell;
        cell = new Cell();
        cell.add(new Paragraph(keysValues));
        cell.setFontSize(10);
        cell.setPadding(10);
        cell.setPaddingBottom(3);
        cell.setFontColor(new DeviceRgb(23,51,68));
        cell.setBackgroundColor(new DeviceRgb(218,232,239));
        cell.setBorder(Border.NO_BORDER);
        academicsTables.addCell(cell);
    }
}