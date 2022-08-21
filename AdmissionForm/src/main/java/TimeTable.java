package main.java;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTable {
    public static void main(String[] args) throws IOException {
        List<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("friday");
        days.add("saturday");
        List<Map<String, Object>> periods = new ArrayList<>();
        Map<String, Object> period = new HashMap<>();
        period.put("periodNum", 1);
        period.put("subject", "");
        period.put("class", "");
        periods.add(period);
        period = new HashMap<>();
        period.put("periodNum", 2);
        period.put("subject", "Physics");
        period.put("class", "9th");
        periods.add(period);
        period = new HashMap<>();
        period.put("periodNum", 3);
        period.put("subject", "Maths");
        period.put("class", "7th");
        periods.add(period);
        period.put("periodNum", 4);
        period.put("subject", "");
        period.put("class", "");
        periods.add(period);
        period = new HashMap<>();
        period.put("periodNum", 5);
        period.put("subject", "Physics");
        period.put("class", "8th");
        periods.add(period);
        period = new HashMap<>();
        period.put("periodNum", 6);
        period.put("subject", "");
        period.put("class", "");
        periods.add(period);
        period = new HashMap<>();
        period.put("periodNum", 7);
        period.put("subject", "Maths");
        period.put("class", "8th");
        periods.add(period);
        period = new HashMap<>();
        period.put("periodNum", 8);
        period.put("subject", "Physics");
        period.put("class", "9th");
        periods.add(period);

        List<Map<String, Object>> teachers = new ArrayList<>();
        Map<String, Object> teacher = new HashMap<>();
        teacher.put("name", "Anil");
        teacher.put("periods", periods);
        teachers.add(teacher);
        teacher = new HashMap<>();
        teacher.put("name", "Sunil");
        teacher.put("periods", periods);
        teachers.add(teacher);
        teacher = new HashMap<>();
        teacher.put("name", "Rohit");
        teacher.put("periods", periods);
        teachers.add(teacher);
        teacher = new HashMap<>();
        teacher.put("name", "Sumit");
        teacher.put("periods", periods);
        teachers.add(teacher);
        teacher = new HashMap<>();
        teacher.put("name", "Sachin");
        teacher.put("periods", periods);
        teachers.add(teacher);
        teacher = new HashMap<>();
        teacher.put("name", "Manpreet");
        teacher.put("periods", periods);
        teachers.add(teacher);
        teacher = new HashMap<>();
        teacher.put("name", "Ritu");
        teacher.put("periods", periods);
        teachers.add(teacher);

        List<Map<String, Object>> dayWiseData = new ArrayList<>();
        for (String day : days) {
            Map<String, Object> eachDay = new HashMap<>();
            eachDay.put("name", day);
            eachDay.put("teachers", teachers);
            dayWiseData.add(eachDay);
        }
        String path = "F:\\timeTable.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument, PageSize.A4.rotate(), true);
        document.setMargins(15, 5, 15, 5);
        for (Map<String, Object> day :dayWiseData){
            print(day, document);
        }
        document.close();
    }

    public static void print(Map<String, Object> day, Document document) throws IOException {
        Table table = new Table(UnitValue.createPercentArray(new float[]{11, 11, 11, 11, 11, 11, 11, 11, 11}));
        table.useAllAvailableWidth();
        table.addCell(createCell(9, 20, 10, "Time Table, "+ day.get("name").toString(), true, false));
        table.addCell(createCell(1, 12, 7, day.get("name").toString(), true, true));
        for (int i = 1; i <= 8; i++) {
            table.addCell(createCell(1,12, 7, ("Period "+ i), new DeviceRgb(192,192,192)));
        }
        List<Map<String, Object>> teachers = (List<Map<String, Object>>) day.get("teachers");
        for (Map<String, Object> teacher: teachers){
            table.addCell(createCell(2,10, 10, teacher.get("name").toString(), new DeviceRgb(192,192,192)));
            List<Map<String, Object>> periods = (List<Map<String, Object>>) teacher.get("periods");
            for (Map<String, Object> period: periods){
                Table childTable = new Table(1);
                childTable.useAllAvailableWidth();
                childTable.setMarginTop(7);
                childTable.setMarginBottom(3);
                childTable.addCell(createCell(1, 9, 0, period.get("subject").toString().equalsIgnoreCase("")?"":period.get("subject").toString(), false , false));
                childTable.addCell(createCell(1, 9, 0,period.get("class").toString().equalsIgnoreCase("") ? "": "Class - "+ period.get("class").toString(), false, false));
                table.addCell(childTable);
            }
        }
        document.add(table);
        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
    }

    private static Cell createCell(int col, int fontsize, int padding, String text,
                                   boolean bold, boolean border) throws IOException {
        Cell cell = new Cell(1, col);
        cell.setVerticalAlignment(VerticalAlignment.TOP);
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setFontSize(fontsize);
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

        cell.setFont(font);
        cell.add(new Paragraph(text));
        cell.setPaddingTop(padding);
        cell.setPaddingBottom(padding);
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        if (bold) {
            cell.setBold();
        }
        if (!border) {
            cell.setBorder(Border.NO_BORDER);
        }
        return cell;
    }
    private static Cell createCell(int spacing, int fontsize, int padding, String text,
                                   DeviceRgb bgcolor) throws IOException {
        Cell cell = new Cell(1, 1);
        cell.setVerticalAlignment(VerticalAlignment.TOP);
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setFontSize(fontsize);
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setBackgroundColor(bgcolor);
        cell.setCharacterSpacing(spacing);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        cell.setFont(font);
        cell.add(new Paragraph(text));
        cell.setPaddingTop(padding);
        cell.setPaddingBottom(padding);
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setBold();
        return cell;
    }

}
