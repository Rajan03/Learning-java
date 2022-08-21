package main.java;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Font {

    public static void main(String[] args) throws IOException {

        String path = "F:\\Learning Java\\IText Pdf\\font.pdf";

        // Pdf Writer
        PdfWriter pdfWriter = new PdfWriter(path);

        // PDF Doc
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        // Document
        Document document = new Document(pdfDocument);
        PdfFont hindi = PdfFontFactory.createFont("F:\\Learning Java\\IText Pdf\\Hind-Regular.ttf");
        Text text = new Text("विद्यार्थी की दैनिक उपस्थर्थनि उसकी शिक्षा केशिए बहु\n" +
                "\n" +
                "ि महत्िप\n" +
                "ू\n" +
                "र्णहै। एक छात्र को\n" +
                "नियशमि रूप सेअपिेसभी अिधियों मेंभाग िेिा चाहहए। ककसी भी छुट्टी के शिए छात्र\n" +
                "को एक हदि पहिेअपिेकक्षा शिक्षक को सू\n" +
                "\n" +
                "धचि करिा चाहहए। यहद कोई छात्र बबिा\n" +
                "\n" +
                "ककसी सू\n" +
                "चिा के साि हदिों िक िगािार अि\n" +
                "ु\n" +
                "पस्थर्थि रहिा है, िो उसका िाम मािा-वपिा\n" +
                "\n" +
                "को बबिा ककसी सू\n" +
                "\n" +
                "चिा के हटा हदया जाएगा।").setFont(hindi);
        document.add(new Paragraph(text));
        document.close();
    }
}
