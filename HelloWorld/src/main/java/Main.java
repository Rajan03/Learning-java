package main.java;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.FontNames;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.image.JpegImageData;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.colorspace.PdfColorSpace;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.font.FontCharacteristics;
import com.itextpdf.layout.property.TextAlignment;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        // Creating a PdfWriter
        String path = "F:\\Learning Java\\IText Pdf\\sample.pdf";
        PdfWriter writer = new PdfWriter(path);

        // Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.addNewPage();
        //Page 1
        Document document = new Document(pdfDoc);

        // Adding paragraph
        String paragraph1 = "\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium " +
                "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi " +
                "architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit " +
                "aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem " +
                "sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, " +
                "adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam " +
                "quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit " +
                "laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui " +
                "in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo " +
                "voluptas nulla pariatur?\"";
        Paragraph para1 = new Paragraph(paragraph1);
        document.add(para1);

        //Adding Lists
        List list = new List();
        list.add("List here");
        list.add("Java");
        list.add("IText");
        list.add("Swing");
        document.add(list);

        // Adding Table
        float [] columnsWidth = {150F, 150F, 150F};
        Table table = new Table(columnsWidth);

            // Cells in Table
        Cell cellOne = new Cell();
        cellOne.add(new Paragraph("Name"));
        cellOne.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cellOne);
        Cell cellTwo = new Cell();
        cellTwo.add(new Paragraph("Name"));
        cellTwo.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cellTwo);
        document.add(table);

            //Border Style
//        Border dashedBorder = new DashedBorder( );
//         Page 2
        AreaBreak areaBreak = new AreaBreak();
        document.add(areaBreak);
        String paragraph = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown " +
                "printer took a galley of type and scrambled it to make a type specimen book. It has survived not " +
                "only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Paragraph para = new Paragraph(paragraph);
        document.add(para);

        // Adding Image
        String imgSrc = "F:\\Learning Java\\HelloWorld\\Images\\salvatore.jpg";
        ImageData imgData = ImageDataFactory.create(imgSrc);
        Image img = new Image(imgData);
        document.add(img);


        // Page 3
        document.add(areaBreak);

            // Adding font gets deprecated (Almost deleted function from language)
        PdfFont font = PdfFontFactory.createFont();

        Paragraph paragraph2 = new Paragraph("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown " +
                "printer took a galley of type and scrambled it to make a type specimen book. It has survived not " +
                "only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.").setFont(font);
        document.add(paragraph2);

        //
        // END
        document.close();

        // Complete
        System.out.println("Pdf Created");
    }
}
