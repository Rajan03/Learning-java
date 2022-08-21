package main.java;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.*;
import com.itextpdf.layout.renderer.CellRenderer;
import com.itextpdf.layout.renderer.DrawContext;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testPdf {

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {

        List<Map<String, String>> staffData = new ArrayList<>();
        Map<String, String> staffInfo = new HashMap<>();
        staffInfo.put("date", "29.01.2021");
        staffInfo.put("name", "Rupinder Kaur");
        staffInfo.put("joiningDate", "1st Jan 2019");
        staffInfo.put("leavingDate", "27th Jan 2021");
        staffInfo.put("jobTitle", "TGT Science Teacher");
        staffData.add(staffInfo);

        staffInfo = new HashMap<>();
        staffInfo.put("date", "27.02.2021");
        staffInfo.put("name", "Ramneet Kaur");
        staffInfo.put("joiningDate", "1st Feb 2019");
        staffInfo.put("leavingDate", "27th Feb 2021");
        staffInfo.put("jobTitle", "TGT Mathematics Teacher");
        staffData.add(staffInfo);

        String path = "F:\\Learning Java\\IText Pdf\\Certificate.pdf";
        // Pdf Writer
        PdfWriter pdfWriter = new PdfWriter(path);
        // PDF Doc
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        PageSize pageSize = PageSize.A4.rotate();

        // Document
        Document document = new Document(pdfDocument);
        for (Map<String, String> eachMember : staffData){
            printPdf(document, eachMember, pdfDocument, pageSize);
        }
        document.close();
    }


    private static Document printPdf(Document document, Map<String, String> eachMember, PdfDocument pdfDocument, PageSize pageSize) throws MalformedURLException {

        document.setMargins(30,30,30,30);

        //BGIMage
        ImageData image = ImageDataFactory.create("C:\\Users\\acer\\Desktop\\bg.jpg");

        // Table
        Table certificate = new Table(UnitValue.createPercentArray(new float[]{50, 50}));
        certificate.useAllAvailableWidth();
        certificate.setHorizontalAlignment(HorizontalAlignment.CENTER);
        certificate.setPadding(30);
        certificate.addCell(new Image(image)).setFixedPosition(50,10,pageSize.getWidth());

        // Cell
        Cell cell = new Cell(1,2);
        cell.setPaddingBottom(270);
        cell.setBorder(Border.NO_BORDER);
        certificate.addCell(cell);

        cell = new Cell();
        cell.add(new Paragraph("Date: " + eachMember.get("date")));
        cell.setFontSize(10);
        cell.setTextAlignment(TextAlignment.LEFT);
        cell.setBorder(Border.NO_BORDER);
        certificate.addCell(cell);

        cell = new Cell();
        cell.add(new Paragraph("Ref. NO.: " + "MLZS/AY-2020-2021/0027"));
        cell.setFontSize(10);
        cell.setTextAlignment(TextAlignment.RIGHT);
        cell.setBorder(Border.NO_BORDER);
        certificate.addCell(cell);

        cell = new Cell(1,2);
        cell.setHeight(65);
        cell.setBorder(Border.NO_BORDER);
        certificate.addCell(cell);

        cell = new Cell(1,2);
        cell.add(new Paragraph("TO WHOM SO EVER IT MAY CONCERN"));
        cell.setPaddingBottom(3);
        cell.setUnderline();
        cell.setWordSpacing(3);
        cell.setBold();
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setFontSize(16);
        certificate.addCell(cell);

        cell = new Cell(1,2);
        Paragraph paragraph = new Paragraph("This is to certify that Mr./Ms. "+ eachMember.get("name") +" has served in the institute from ");
        paragraph.add(new Text(eachMember.get("joiningDate") + " to " + eachMember.get("leavingDate")).setBold());
        paragraph.add(" as a ");
        paragraph.add(new Text(eachMember.get("jobTitle")).setBold());
        paragraph.add(". She has a genial temperament and worked efficiently in her team.");
        cell.add(paragraph);
        cell.setWordSpacing(3);
        cell.setPaddingTop(30);
        cell.setBorder(Border.NO_BORDER);
        certificate.addCell(cell);

        cell = new Cell(1,2);
        cell.add(new Paragraph("We wish her all the best for her future endeavor."));
        cell.setPaddingTop(10);
        cell.setWordSpacing(3);
        cell.setBorder(Border.NO_BORDER);
        certificate.addCell(cell);

        cell = new Cell(1,2);
        cell.setPaddingBottom(290);
        cell.setBorder(Border.NO_BORDER);
        certificate.addCell(cell);

        // ADD Table
        document.add(certificate);
        document.add(new AreaBreak());
        return document;
    }
}
