package main.java;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.*;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.*;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SamplePdf {

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {

        String path = "F:\\Learning Java\\IText Pdf\\SamplePdf.pdf";
        List<Map<String, Object>> studentsDb = getStudents();

        // Pdf Writer
        PdfWriter pdfWriter = new PdfWriter(path);

        // PDF Doc
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        PdfPage page = pdfDocument.addNewPage();

        // Document
        Document document = new Document(pdfDocument);
        document.setMargins(0,0,0,0);


        //Parent table
        Table parentTable = new Table(2);
        parentTable.useAllAvailableWidth();
        parentTable.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
        parentTable.setVerticalBorderSpacing(7);
        parentTable.setHorizontalBorderSpacing(7);

        // Card
        for (Map<String, Object> eachStudent : studentsDb) {
            String name = eachStudent.get("name").toString();
            String admNo = eachStudent.get("admissionNo").toString();
            String grade = eachStudent.get("class").toString();
            String fatherName = eachStudent.get("fatherName").toString();
            String house = eachStudent.get("house").toString();
            Cell cell = new Cell();
            cell.setMaxWidth(UnitValue.createPercentValue(50));
            cell.setPadding(7);
            cell.add(backgroundDesign());
            cell.add(studentData(name, admNo, grade, fatherName, house));
            parentTable.addCell(cell);
        }
        document.add(parentTable);
        document.close();
    }
    private static Table backgroundDesign(){
        Table studentIdCard = new Table(1);
        studentIdCard.useAllAvailableWidth();

        Cell cardCell = new Cell();
        cardCell.setBackgroundColor(new DeviceRgb(175,26,0));
        cardCell.add(new Paragraph("Hogwarts Magic School"));
        cardCell.setBold();
        cardCell.setFontSize(17);
        cardCell.setFontColor(new DeviceRgb(255,255,255));
        cardCell.setBorder(Border.NO_BORDER);
        cardCell.setTextAlignment(TextAlignment.RIGHT);
        cardCell.setPadding(10);

        studentIdCard.addCell(cardCell);
        return studentIdCard;
    }
    private static Table studentImg() throws MalformedURLException {
        Image image = new Image(ImageDataFactory.create("C:\\Users\\acer\\Desktop\\2.jpg"));

        Border imgBorder = new DoubleBorder(new DeviceRgb(0,0,0), 2);
        image.setBorder(imgBorder);

        Table studentImg = new Table(1);
        studentImg.useAllAvailableWidth();

        Cell imgCell = new Cell();
        imgCell.add(image.setWidth(60));
        imgCell.setBorder(Border.NO_BORDER);

        return studentImg.addCell(imgCell);
    }
    private static Table studentData(String name, String admNo, String grade, String fatherName, String house) throws MalformedURLException {

        Table studentData = new Table(UnitValue.createPercentArray(new float[]{30,25,15,30}));
        studentData.useAllAvailableWidth();
        studentData.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
        studentData.setVerticalBorderSpacing(3);
        studentData.setHorizontalBorderSpacing(3);

        Cell cell = new Cell(1,3);
        cell.add(new Paragraph(name + " \n").setFontSize(17));
        cell.add(new Paragraph("House "+ house).setFontSize(9).setFontColor(new DeviceRgb(118, 140, 159)));
        cell.setBold();
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.CENTER);
        studentData.addCell(cell);

        cell = new Cell(2,1);
        cell.add(studentImg());
        cell.setBorder(Border.NO_BORDER);
        studentData.addCell(cell);

        cell = new Cell();
        cell.add(new Paragraph("Admission No. \n").setFontSize(10).setFontColor(new DeviceRgb(175, 26, 0)));
        cell.add(new Paragraph(admNo).setFontSize(9));
        cell.setBold();
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.LEFT);
        studentData.addCell(cell);

        cell = new Cell();
        cell.add(new Paragraph("Class \n").setFontSize(10).setFontColor(new DeviceRgb(175, 26, 0)));
        cell.add(new Paragraph(grade).setFontSize(9));
        cell.setBold();
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.LEFT);
        studentData.addCell(cell);

        cell = new Cell();
        cell.setBorder(Border.NO_BORDER);
        studentData.addCell(cell);

        cell = new Cell(1,2);
        cell.add(new Paragraph("Father Name \n").setFontSize(10).setFontColor(new DeviceRgb(175, 26, 0)));
        cell.add(new Paragraph(fatherName).setFontSize(9));
        cell.setBold();
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.LEFT);
        studentData.addCell(cell);

        cell = new Cell(1,2);
        cell.add(new Paragraph("Principal Signature"));
        cell.setFontSize(10);
        cell.setBold();
        cell.setVerticalAlignment(VerticalAlignment.BOTTOM);
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.RIGHT);
        studentData.addCell(cell);

        return studentData;
    }

    private static List<Map<String, Object>> getStudents() {
        List<Map<String, Object>> students = new ArrayList<>();
        Map<String, Object> student = new HashMap<>();

// Student 1
        student.put("name", "Harry Potter");
        student.put("class", "12th");
        student.put("fatherName", "Severus Sanpe");
        student.put("admissionNo", "5410");
        student.put("house", "Gryffindor");
        students.add(student);

// Student 2
        student = new HashMap<>();
        student.put("name", "Ron Weasley");
        student.put("class", "12th");
        student.put("fatherName", "George Weasley");
        student.put("admissionNo", "5419");
        student.put("house", "Ravenclaw");
        students.add(student);

// Student 3
        student = new HashMap<>();
        student.put("name", "Hermaione Granger");
        student.put("class", "12th");
        student.put("fatherName", "Wendell Gransger");
        student.put("admissionNo", "4690");
        student.put("house", "Gryffindor");
        students.add(student);

// Student 4
        student = new HashMap<>();
        student.put("name", "Ginny Weasley");
        student.put("class", "12th");
        student.put("fatherName", "George Weasley");
        student.put("admissionNo", "8452");
        student.put("house", "Hufflepuff");
        students.add(student);

// Student 5
        student = new HashMap<>();
        student.put("name", "Draco Malfoy");
        student.put("class", "12th");
        student.put("fatherName", "Lucius Malfoy");
        student.put("admissionNo", "8195");
        student.put("house", "Slythrine");
        students.add(student);

// Student 6
        student = new HashMap<>();
        student.put("name", "Luna Lovegood");
        student.put("class", "12th");
        student.put("fatherName", "Remus Lovegood");
        student.put("admissionNo", "8195");
        student.put("house", "Slythrine");
        students.add(student);

// Student 5
        student = new HashMap<>();
        student.put("name", "Draco Malfoy");
        student.put("class", "12th");
        student.put("fatherName", "Lucius Malfoy");
        student.put("admissionNo", "8195");
        student.put("house", "Slythrine");
        students.add(student);

// Student 6
        student = new HashMap<>();
        student.put("name", "Luna Lovegood");
        student.put("class", "12th");
        student.put("fatherName", "Remus Lovegood");
        student.put("admissionNo", "8195");
        student.put("house", "Slythrine");
        students.add(student);
        return students;

    }
}

