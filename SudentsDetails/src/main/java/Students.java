package main.java;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Students {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "F:\\Learning Java\\IText Pdf\\students.pdf";
        Object[]


            //PDF Writer
            PdfWriter writer = new PdfWriter(path);

            // PDF Doc
            PdfDocument pdfDocument = new PdfDocument(writer);

            // Document
        Document document = new Document(pdfDocument);
        List<Map<String, Object>> students = getStudents();
        for (int i = 0; i < students.size(); i++){
            // Table
            Table studentTable = new Table(2);
            studentTable.useAllAvailableWidth();

            Cell cell = new Cell();
            cell.add(new Paragraph("Name "));
            cell.setBold();
            cell.setBorder(Border.NO_BORDER);
            cell.setTextAlignment(TextAlignment.LEFT);
            studentTable.addCell(cell);

            /*cell = new Cell();
            cell.add(new Paragraph(": " + students.get(i).get("name").toString()));
            cell.setBorder(Border.NO_BORDER);
            cell.setTextAlignment(TextAlignment.LEFT);
            studentTable.addCell(cell);

            cell = new Cell();
            cell.add(new Paragraph("Father Name "));
            cell.setBorder(Border.NO_BORDER);
            cell.setBold();
            cell.setTextAlignment(TextAlignment.LEFT);
            studentTable.addCell(cell);

            cell = new Cell();
            cell.add(new Paragraph(": " + students.get(i).get("fatherName").toString()));
            cell.setBorder(Border.NO_BORDER);
            cell.setTextAlignment(TextAlignment.LEFT);
            studentTable.addCell(cell);

            cell = new Cell();
            cell.add(new Paragraph("Class "));
            cell.setBold();
            cell.setBorder(Border.NO_BORDER);
            cell.setTextAlignment(TextAlignment.LEFT);
            studentTable.addCell(cell);

            cell = new Cell();
            cell.add(new Paragraph(": " + students.get(i).get("class").toString()));
            cell.setBorder(Border.NO_BORDER);
            cell.setTextAlignment(TextAlignment.LEFT);
            studentTable.addCell(cell);

            cell = new Cell();
            cell.add(new Paragraph("Admission No. "));
            cell.setBorder(Border.NO_BORDER);
            cell.setBold();
            cell.setTextAlignment(TextAlignment.LEFT);
            studentTable.addCell(cell);

            cell = new Cell();
            cell.add(new Paragraph(": " + students.get(i).get("admissionNo")));
            cell.setBorder(Border.NO_BORDER);
            cell.setTextAlignment(TextAlignment.LEFT);
            studentTable.addCell(cell);*/

            document.add(studentTable);
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        }
        document.close();
    }

    public static List<Map<String, Object>> getStudents() {
        List<Map<String, Object>> students = new ArrayList<>();
        Map<String, Object> student = new HashMap<>();

// Student 1
        student.put("name", "Rajat Kumar");
        student.put("class", "12th");
        student.put("fatherName", "Pawan Kumar");
        student.put("admissionNo", "5410");
        students.add(student);

// Student 2
        student = new HashMap<>();
        student.put("name", "Sandeep Kumar");
        student.put("class", "12th");
        student.put("fatherName", "Karan kumar");
        student.put("admissionNo", "5419");
        students.add(student);

// Student 3
        student = new HashMap<>();
        student.put("name", "Mukesh Verma");
        student.put("class", "12th");
        student.put("fatherName", "Ranjit Verma");
        student.put("admissionNo", "4690");
        students.add(student);

// Student 4
        student = new HashMap<>();
        student.put("name", "Vivek Singh");
        student.put("class", "12th");
        student.put("fatherName", "Jashan Singh");
        student.put("admissionNo", "8452");
        students.add(student);

// Student 5
        student = new HashMap<>();
        student.put("name", "Vicky");
        student.put("class", "12th");
        student.put("fatherName", "Vikram");
        student.put("admissionNo", "8195");
        students.add(student);

        return students;
    }

}


