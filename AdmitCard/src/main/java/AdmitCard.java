package main.java;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPageEventHelper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class AdmitCard {


    public  void print()  {

        String path = "F:\\AdmitCard.pdf";
        String image = "https://storage.zimong.com/zmg-demo/images/sanslogo.png";
        URL imgUrl = new URL(image);

        // Pdf Writer
        PdfWriter pdfWriter = new PdfWriter(path);

        // PDF Doc
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new PublicBackgroundEventHandler(image));

        // Document
        Document document = new Document(pdfDocument);

        Table table = new Table(1);
        table.useAllAvailableWidth();
        table.setBorder(new SolidBorder(1));


        createCell(1, 1, "SARASWATI TALENT HUNT EXAMINATION 2021", 2, 18, TextAlignment.CENTER, table,
                true, false, false, false, false);
        createCell(1, 1, "ADMIT CARD", 1, 13, TextAlignment.CENTER, table, false, false,
                false, false, false);

        document.add(table);
        table = new Table(UnitValue.createPercentArray(new float[]{12, 10, 20, 17, 17, 15}));
        table.useAllAvailableWidth();

        createCell(1, 6, "Candidate Details: ", 3, 10, TextAlignment.LEFT, table, true, false,
                false, false, false);

        createCell(1, 1, "ROLL NO.: ", 1, 11, TextAlignment.LEFT, table, false, true,
                false, true, true);

        String rollNo = "00195";
        createCell(1, 2, rollNo, 1, 11, TextAlignment.LEFT, table, true, false,
                true, true, true);

        String level = "2";
        createCell(1, 3, "Level: " + level, 1, 11, TextAlignment.CENTER, table, false, true,
                true, true, true);

        createCell(1, 1, "NAME: ", 1, 11, TextAlignment.LEFT, table, false, true,
                false, true, true);

        String name = "RAMAN KAMBOJ";
        createCell(1, 2, name, 1, 11, TextAlignment.LEFT, table, true, false,
                true, true, true);

        createCell(1, 3, "TIMING AND DATE: ", 1, 11, TextAlignment.CENTER, table, true, true,
                true, true, false);

        createCell(1, 2, "FATHER NAME: ", 1, 11, TextAlignment.LEFT, table, false, true,
                false, true, true);

        String fatherName = "KARAN KAMBOJ";
        createCell(1, 1, fatherName, 1, 11, TextAlignment.LEFT, table, true, false,
                false, false, false);

        String time = "10:30 AM", date = "\n 07/03/2021 (SUNDAY)", phone = "8708609336";
        createCell(1, 3, time + date + "\n PHONE: " + phone, 1, 12, TextAlignment.CENTER,
                table, false, true, true, false, true);

        createCell(1, 1, "ADDRESS: ", 1, 11, TextAlignment.LEFT, table, false, true,
                false, true, true);

        String address = "NEW RAJPURA";
        createCell(1, 5, address, 1, 11, TextAlignment.LEFT, table, true, false,
                true, true, true);

        createCell(1, 6, "Instructions: ", 1, 10, TextAlignment.LEFT, table, true, true,
                true, true, false);

        createCell(1, 6, "This admit card will only be valid after it is signed by exam controller and principal. \n " +
                        "Candidate must bring this admit card to secure admission to examination room.", 0, 10,
                TextAlignment.LEFT, table, false, true, true, false, true);

        createCell(1, 1, "VENUE: ", 1, 10, TextAlignment.LEFT, table, true, true,
                false, true, true);

        String venue = "SARASWATI SENIOR SECONDARY SCHOOL ";
        createCell(1, 3, venue, 1, 10, TextAlignment.LEFT, table, true, false,
                true, true, true);

        createCell(1, 2, "Ph." + phone, 1, 10, TextAlignment.LEFT, table, true, false,
                true, true, true);

        createCell(1, 3, "EXAMINATION CONTOLLER", 30, 11, TextAlignment.LEFT, table, false, true,
                false, false, true);

        createCell(1, 3, "PRINCIPAL ", 30, 11, TextAlignment.RIGHT, table, false, false,
                true, false, true);

        document.add(table);
        document.close();

    }

    private static void createCell(int row, int col, String str, int paddingTop, int fontSize, TextAlignment alignment, Table table,
                                   boolean bold, boolean leftBorder, boolean rightBorder, boolean topBorder,
                                   boolean bottomBorder) throws IOException {
        PdfFont fontReg = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        Cell cell = new Cell(row, col);
        cell.add(new Paragraph(str));
        cell.setFontSize(fontSize);
        cell.setPaddingTop(paddingTop);
        cell.setTextAlignment(alignment);
        cell.setVerticalAlignment(VerticalAlignment.TOP);
        if (bold) {
            cell.setFont(fontBold);
        } else {
            cell.setFont(fontReg);
        }
        if (!leftBorder) {
            cell.setBorderLeft(Border.NO_BORDER);
        }
        if (!rightBorder) {
            cell.setBorderRight(Border.NO_BORDER);
        }
        if (!topBorder) {
            cell.setBorderTop(Border.NO_BORDER);
        }
        if (!bottomBorder) {
            cell.setBorderBottom(Border.NO_BORDER);
        }
        table.addCell(cell);
    }


    static class PublicBackgroundEventHandler implements IEventHandler {

        String label = "";

        PublicBackgroundEventHandler(String label) {
            this.label = label;
        }

        @Override
        public void handleEvent(Event event) {

        }
    }
}


