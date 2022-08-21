package main.java;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TcCertificate {

    public static void main(String[] args) throws IOException {

        List<Map<String, Object>> studentData = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();
        data.put("studentName", "Somay Saharan");
        data.put("fatherName", "Mahesh Sharan");
        data.put("motherName", "Sunita Saharan");
        data.put("grade", "7th");
        data.put("admNo", "2748");
        data.put("dob", "11/11/2010");
        studentData.add(data);

        data = new HashMap<>();
        data.put("studentName", "Gurpreet Saharan");
        data.put("fatherName", "Mahesh Sharan");
        data.put("motherName", "Sunita Saharan");
        data.put("grade", "7th");
        data.put("admNo", "2448");
        data.put("dob", "16/11/2010");
        studentData.add(data);

        print(studentData);
    }
    public static void print(List<Map<String, Object>> studentData) throws IOException {
        String path = "F:\\TC.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        for (Map<String, Object> eachStudent : studentData){
            document.setMargins(0,20,0,20);
            Table table = new Table(2);
            Cell cell = new Cell(1,2);
            cell.add(new Paragraph("Header Here"));
            cell.setTextAlignment(TextAlignment.CENTER);
//            document.add(AreaBreak);
            table.addCell(cell);

            cell = new Cell(1,2);
            cell.setTextAlignment(TextAlignment.CENTER);
            Paragraph text = new Paragraph("This is to certify that ");
            text.add(new Text(eachStudent.get("studentName").toString()).setBold());
            text.add(" S/O of Shri ");
            text.add(new Text(eachStudent.get("fatherName").toString()).setBold());
            text.add(" and Smt. ");
            text.add(new Text(eachStudent.get("motherName").toString()).setBold());
            text.add(", is a regular student of our school and is studying in class ");
            text.add(new Text(eachStudent.get("grade").toString()).setBold());
            text.add(". His admission number is ");
            text.add(new Text(eachStudent.get("admNo").toString()).setBold());
            text.add(". His date of birth is ");
            text.add(new Text(eachStudent.get("dob").toString()).setBold());
            cell.add(text);
            cell.setFixedPosition(20, 520, 100);
            cell.setBorder(Border.NO_BORDER);
            table.addCell(cell);

            cell =new Cell(1,2);
            cell.setTextAlignment(TextAlignment.RIGHT);
            cell.add(new Paragraph("Principal"));
            cell.setPaddingRight(20);
            cell.setBold();
            cell.setFixedPosition(20, 370, 100);
            cell.setBorder(Border.NO_BORDER);
            table.addCell(cell);

            document.add(table);
            document.add(new AreaBreak());
        }
        document.close();
    }

}
