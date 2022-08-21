package main.java;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.BorderCollapsePropertyValue;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeeCertificate {
    public static void print() throws FileNotFoundException {
        String path = "F:\\fee.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        document.add(formTable());
        document.add(feeTable());
        document.close();
    }
    private static Cell createCell(int row, int col, String str, TextAlignment align, int letterSpacing, int fontSize,
                                   boolean bold, boolean underline, boolean border){

        Cell cell = new Cell(row, col);
        Text text = new Text(str);
        cell.add(new Paragraph(text));
        cell.setTextAlignment(align);
        cell.setFontSize(fontSize);
        cell.setCharacterSpacing(letterSpacing);
        cell.setVerticalAlignment(VerticalAlignment.BOTTOM);
        if (!border) {
            cell.setBorder(Border.NO_BORDER);
        }
        if (bold){
            cell.setBold();
        }
        if (underline){
            cell.setUnderline();
        }
        return cell;
    }

    private static Cell createCell(int row, int col, String str, TextAlignment align, int letterSpacing, int fontSize,
                                   boolean bold, boolean underline, boolean border,int padding){
        Cell cell = createCell(row, col, str, align, letterSpacing, fontSize, bold, underline, border);
        cell.setPadding(padding);
        cell.setPaddingTop(0);
        return cell;
    }

    private static Table formTable(){
        Table table = new Table(UnitValue.createPercentArray(new float[]{50,50}));
        table.useAllAvailableWidth();
        table.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
        table.setVerticalBorderSpacing(20);
        table.setHorizontalBorderSpacing(5);
        table.setMarginBottom(20);
        table.addCell(createCell(1,2,"Fees Receipt", TextAlignment.CENTER,2,12, true,
                true,false));
        table.addCell(createCell(1,1,"Receipt No.: " + "___________________",TextAlignment.LEFT,1,
                9,false,false,false));
        table.addCell(createCell(1,1,"Date: " + LocalDate.now(),TextAlignment.RIGHT,1,
                9,false,false,false));
        table.addCell(createCell(1,1,"Student Name: " + "_________________________",TextAlignment.LEFT,1,
                9, false,false,false));
        table.addCell(createCell(1,1,"Father Name: " + "_____________________________",TextAlignment.LEFT,1,
                9, false,false,false));
        table.addCell(createCell(1,1,"Class: " + "_______________________________",TextAlignment.LEFT,1,
                9,false,false,false));
        table.addCell(createCell(1,1,"Session: " + "_________________________________",TextAlignment.LEFT,1,
                9,false,false,false));
        table.addCell(createCell(1,1,"Aadhar No.: " + "___________________________",TextAlignment.LEFT,1,
                9,false,false,false));
        table.addCell(createCell(1,1,"Sr. No.: " + "__________________________________",TextAlignment.LEFT,1,
                9,false,false,false));
        table.addCell(createCell(1,2,"Address: " + "__________________________________________________________________" +
                "__________",TextAlignment.LEFT,1,9, false,false,false));
        return table;
    }

    private static Table feeTable(){
        Map<String,String> feeData = new HashMap<>();
        feeData.put("Registration Fees","100");
        feeData.put("Administration Charges", "100");
        feeData.put("Tuition Fees", "9000");
        feeData.put("Electricity and Water Charges", "1500");
        feeData.put("Contingency Fees", "1800");
        feeData.put("Internal Examination Fees", "500");
        feeData.put("Sports Fees", "500");
        feeData.put("Library Charges", "800");
        feeData.put("Lab Charges", "2000");
        feeData.put("Academic Self Reliance Fees", "250");

        Table table = new Table(UnitValue.createPercentArray(new float[]{15, 45, 40}));
        table.useAllAvailableWidth();
        table.setMarginLeft(40);
        table.setMarginRight(40);

        table.addCell(createCell(1,3,"D.El.Ed Fees Receipt Bifurcation",TextAlignment.CENTER,2,
                10, true,true,false).setPaddingBottom(10));
        table.addCell(createCell(1,1,"Sr. No.", TextAlignment.CENTER,1,9, true,
                false, true));
        table.addCell(createCell(1,1,"Head", TextAlignment.CENTER,1,9, true,
                false, true));
        table.addCell(createCell(1,1,"Amount", TextAlignment.CENTER,1,9, true,
                false, true));
        int count = 1;
        for (Map.Entry<String, String> pair : feeData.entrySet()){
            table.addCell(createCell(1,1,String.valueOf(count++), TextAlignment.CENTER,1,9, false,
                    false, true,4));
            table.addCell(createCell(1,1,pair.getKey(), TextAlignment.LEFT,1,9, false,
                    false, true,4));
            table.addCell(createCell(1,1,pair.getValue(), TextAlignment.CENTER,1,9, false,
                    false, true,4));
        }
        int sum = 0;
        for (Map.Entry<String, String> pair : feeData.entrySet()){
            sum += Integer.parseInt(pair.getValue());
        }
        table.addCell(createCell(1,2,"Total ",TextAlignment.CENTER,1,10,true,
                false,true,8));
        table.addCell(createCell(1,1,String.valueOf(sum),TextAlignment.CENTER,1,9,false,
                false,true,8));
        table.addCell(createCell(1,3,"(Amount in words : "+"Sixteen Thousand Five Hundred Fifty Five Rupees Only)",
                TextAlignment.LEFT, 1,9,false,false,false,0));

        return table;
    }
}

