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
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.*;

import java.io.IOException;

public class FeeCertificate {

    public static void main(String[] args) throws IOException {
        print();
    }
    public static void print() throws IOException {
        String path = "F:\\feeCertificate.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument, PageSize.A4.rotate(), true);
        document.setMargins(18, 32, 8, 32);
        Table table = new Table(UnitValue.createPercentArray(new float[]{50, 50}));
        table.useAllAvailableWidth();
        Cell cell = new Cell();
        cell.add(feeReceipt());
        cell.setBorder(Border.NO_BORDER);
        cell.setPaddingRight(20);
        cell.setBorderRight(new SolidBorder(1));
        table.addCell(cell);
        cell = new Cell();
        cell.setBorder(Border.NO_BORDER);
        cell.setPaddingLeft(20);
        cell.add(feeReceipt());
        table.addCell(cell);
        document.add(table);
        document.close();
    }
    private static Table feeReceipt() throws IOException {
        Table childTable = new Table(1);
        childTable.useAllAvailableWidth();
        Cell childCell = new Cell().add(renderHeader());
        childCell.setBorder(Border.NO_BORDER);
        childTable.addCell(childCell);
        childCell = new Cell().add(borderTable());
        childCell.setBorder(Border.NO_BORDER);
        childTable.addCell(childCell);
        childCell = new Cell().add(studentTable());
        childCell.setBorder(Border.NO_BORDER);
        childTable.addCell(childCell);
        childCell = new Cell().add(feeData());
        childCell.setBorder(Border.NO_BORDER);
        childTable.addCell(childCell);
        return childTable;
    }
    private static Table renderHeader() throws IOException {
        Table table = new Table(UnitValue.createPercentArray(new float[]{40, 32, 22}));
        table.useAllAvailableWidth();
        String schlName = "Saraswati sen. sec. school";
        table.addCell(createCell(1, 3, 18, 1, schlName.toUpperCase(), TextAlignment.CENTER, true, false).setWordSpacing(5));
        table.addCell(createCell(1, 3, 8, 1, "(English Medium, CBSE Pattern)", TextAlignment.CENTER, true, false));
        table.addCell(createCell(10, 0, 0, 2, 2,
                "VILL. MAUJGARH (SIRSA)", new DeviceRgb(222, 222, 222),
                new DeviceRgb(0, 0, 0)));
        table.addCell(createCell(12, 20, 20, 5, 5,
                "Fee Receipt/Invoice: [Student Copy]",
                new DeviceRgb(0, 0, 0), new DeviceRgb(222, 222, 222)).setWordSpacing(4));
        return table;
    }
    private static Table borderTable() throws IOException {
        Table table = new Table(UnitValue.createPercentArray(new float[]{49, 1, 50}));
        table.useAllAvailableWidth();
        table.setMarginTop(5);
        table.setMarginBottom(5);
        table.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
        table.setHorizontalBorderSpacing(4);
        table.setBorder(new SolidBorder(1));
        table.setBorderRadius(new BorderRadius(10, 10));
        table.addCell(createCell(1, 1, 11, 1, "Session:_______________", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 1, 11, 1, "", TextAlignment.CENTER, true, false));
        table.addCell(createCell(1, 1, 11, 1, "Fee Period:_______________", TextAlignment.RIGHT, false, false));

        table.addCell(createCell(1, 1, 11, 1, "Date:_______________", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 1, 11, 1, "", TextAlignment.CENTER, true, false));
        table.addCell(createCell(1, 1, 11, 1, "Receipt No.:_______________", TextAlignment.RIGHT, false, false));
        return table;
    }
    private static Table studentTable() throws IOException {
        Table table = new Table(UnitValue.createPercentArray(new float[]{45, 1, 55}));
        table.useAllAvailableWidth();
        table.addCell(createCell(1, 1, 11, 1, "Adm No.:_______________", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 1, 11, 1, "", TextAlignment.CENTER, true, false));
        table.addCell(createCell(1, 1, 11, 1, "Class:_______________", TextAlignment.RIGHT, false, false));

        table.addCell(createCell(1, 1, 11, 1, "Name:_______________", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 1, 11, 1, "", TextAlignment.CENTER, true, false));
        table.addCell(createCell(1, 1, 11, 1, "Father:_______________", TextAlignment.RIGHT, false, false));

        table.addCell(createCell(1, 1, 11, 1, "Mother:_______________", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 1, 11, 1, "", TextAlignment.CENTER, true, false));
        table.addCell(createCell(1, 1, 11, 1, "Payment Mode:_______________", TextAlignment.RIGHT, false, false));
        return table;
    }
    private static Table feeData() throws IOException {
        Table table = new Table(UnitValue.createPercentArray(new float[]{15, 30, 30, 18}));
        table.useAllAvailableWidth();
        table.addCell(createCell(1, 4, 14, 0, "Fee Receipt", TextAlignment.CENTER, true, false).setPaddingTop(6));
        Cell cell = createCell(1, 1, 10, 2, "Sr. No.", TextAlignment.CENTER, true, false)
                .setBorderTop(new SolidBorder(1))
                .setBorderBottom(new SolidBorder(1));
        table.addCell(cell);
        cell = createCell(1, 1, 10, 2, "Particulars", TextAlignment.CENTER, true, false)
                .setBorderTop(new SolidBorder(1))
                .setBorderBottom(new SolidBorder(1));
        table.addCell(cell);
        cell = createCell(1, 1, 10, 2, "Period", TextAlignment.CENTER, true, false)
                .setBorderTop(new SolidBorder(1))
                .setBorderBottom(new SolidBorder(1));
        table.addCell(cell);
        cell = createCell(1, 1, 10, 2, "Fee", TextAlignment.CENTER, true, false)
                .setBorderTop(new SolidBorder(1))
                .setBorderBottom(new SolidBorder(1));
        table.addCell(cell);
        for (int i = 1; i <= 7; i++) {
            table.addCell(createCell(1, 1, 10, 1, String.valueOf(i), TextAlignment.CENTER, false, false));
            table.addCell(createCell(1, 1, 10, 1, "MISCELLANEOUS FEE", TextAlignment.LEFT, false, false));
            table.addCell(createCell(1, 1, 10, 1, "(TOTAL FEE)", TextAlignment.CENTER, false, false));
            table.addCell(createCell(1, 1, 10, 1, "200.00", TextAlignment.CENTER, false, false));
        }
        cell = createCell(1, 3, 11, 0, "Grand Total (1st Installment)", TextAlignment.LEFT, true, false)
                .setBorderTop(new SolidBorder(1));
        table.addCell(cell);
        cell = createCell(1, 1, 11, 0, "20000", TextAlignment.CENTER, false, false)
                .setBorderTop(new SolidBorder(1));
        table.addCell(cell);
        cell = createCell(1, 3, 9, 0, "Deposit", TextAlignment.LEFT, false, false);
        table.addCell(cell);
        cell = createCell(1, 1, 9, 0, "10000", TextAlignment.CENTER, false, false);
        table.addCell(cell);
        cell = createCell(1, 3, 9, 0, "Balance", TextAlignment.LEFT, false, false)
                .setBorderBottom(new SolidBorder(1));
        table.addCell(cell);
        cell = createCell(1, 1, 9, 0, "10000", TextAlignment.CENTER, false, false)
                .setBorderBottom(new SolidBorder(1));
        table.addCell(cell);
        table.addCell(createCell(1, 3, 11, 0, "Net Fee: ", TextAlignment.LEFT, true, false));
        table.addCell(createCell(1, 1, 11, 0, "40000 ", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 3, 11, 0, "Total Deposit: ", TextAlignment.LEFT, true, false));
        table.addCell(createCell(1, 1, 11, 0, "20000", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 3, 11, 0, "Balance: ", TextAlignment.LEFT, true, false));
        table.addCell(createCell(1, 1, 11, 0, "20000", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 3, 11, 0, "Next Due Date: ", TextAlignment.LEFT, true, false));
        table.addCell(createCell(1, 1, 11, 0, "15/aug/2021", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 3, 11, 0, "Last Fine After Due Date: ", TextAlignment.LEFT, true, false));
        table.addCell(createCell(1, 1, 11, 0, "24% interest", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 4, 12, 0, "Note: Fee once paid is refundable/adjustable.", TextAlignment.LEFT, false, false).setPaddingBottom(15));

        table.addCell(createCell(1, 2, 9, 0, "Fee Deposited By:", TextAlignment.LEFT, false, false).setBorderBottom(new SolidBorder(1)));
        table.addCell(createCell(1, 1, 9, 0, "Fee Collected By:", TextAlignment.LEFT, false, false).setBorderBottom(new SolidBorder(1)));
        table.addCell(createCell(1, 1, 9, 0, "Verified By:", TextAlignment.LEFT, false, false).setBorderBottom(new SolidBorder(1)));
        table.addCell(createCell(1, 2, 8, 0, "Email: saraswatischoolmaujgarh@yahoo.com", TextAlignment.LEFT, false, false));
        table.addCell(createCell(1, 2, 8, 0, "Ph: 9416491027, 9468146786", TextAlignment.RIGHT, false, false));
        return table;
    }
    private static Cell createCell(int row, int col, int fontsize, int padding, String text,
                                   TextAlignment alignment, boolean bold, boolean border) throws IOException {
        Cell cell = new Cell(row, col);
        cell.setVerticalAlignment(VerticalAlignment.TOP);
        cell.setTextAlignment(alignment);
        cell.setFontSize(fontsize);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

        cell.setFont(font);
        cell.add(new Paragraph(text));
        cell.setPadding(padding);
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        if (bold) {
            cell.setBold();
        }
        if (!border) {
            cell.setBorder(Border.NO_BORDER);
        }
        return cell;
    }
    private static Cell createCell(int fontsize, int paddingRight, int paddingLeft, int paddingTop, int paddingBottom, String text,
                                   DeviceRgb color, DeviceRgb bgColor) throws IOException {
        Cell cell = new Cell(1, 3);
        cell.setVerticalAlignment(VerticalAlignment.TOP);
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setFontSize(fontsize);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        cell.setFont(font);
        cell.add(new Paragraph(text));
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setBold();
        cell.setBorder(Border.NO_BORDER);
        cell.setFontColor(color);
        cell.setPaddingTop(paddingTop);
        cell.setPaddingBottom(paddingBottom);
        cell.setPaddingRight(paddingRight);
        cell.setPaddingLeft(paddingLeft);
        cell.setBackgroundColor(bgColor);
        return cell;
    }
}
