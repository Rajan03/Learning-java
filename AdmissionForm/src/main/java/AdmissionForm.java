package main.java;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.IOException;
import java.net.URL;

public class AdmissionForm {
//    public static void main(String[] args) throws IOException {
//        String path = "F:\\admissionForm.pdf";
//
//        PdfWriter pdfWriter = new PdfWriter(path);
//        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//
//        Document document = new Document(pdfDocument, PageSize.A4, true);
//        document.setMargins(50,45,50,45);
//
//        Table table = new Table(UnitValue.createPercentArray(new float[]{40,35,25}));
//        table.useAllAvailableWidth();
//
//        table.addCell(createCell(1,3,20,5, "SHREE DEICHAND MANGERAM SMART SCHOOL", TextAlignment.CENTER,
//                true, false));
//        table.addCell(createCell(1,2,20,5, "SESSION –2021-22", TextAlignment.CENTER,
//                true, false));
//        table.addCell(createCell("https://storage.zimong.com/zmg-demo/images/sanslogo.png"));
//        table.addCell(createCell(1,2,18,10, "S.NAME - ............................................", TextAlignment.LEFT,
//                true, false));
//        table.addCell(createCell(1,2,18,10, "F.NAME - ............................................", TextAlignment.LEFT,
//                true, false));
//        table.addCell(createCell(1,2,18,10, "VILLAGE - ...........................................", TextAlignment.LEFT,
//                true, false));
//        table.addCell(createCell(1,2,18,10, "MOBILE NO. - ......................................", TextAlignment.LEFT,
//                true, false));
//        table.addCell(createCell(1,1,18,1, "", TextAlignment.LEFT,
//                true, false));
//        table.addCell(createCell(1,3,20,15, "Fee details", TextAlignment.CENTER,
//                true, false));
//        table.addCell(createCell(1,1,10,5,"",TextAlignment.CENTER,false, true));
//        table.addCell(createCell(1,1,18,5,"During Admission/ Before 15 April",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,18,5,"Before 15 October",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"ReAdmission Fee",TextAlignment.LEFT,false, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"Exam charge",TextAlignment.LEFT,false, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"Tuition Fee",TextAlignment.LEFT,false, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"Van Charge",TextAlignment.LEFT,false, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"Late Fee",TextAlignment.LEFT,false, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"Total",TextAlignment.LEFT,false, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,1,17,5,"",TextAlignment.LEFT,true, true));
//        table.addCell(createCell(1,3,17,10,"Terms and Conditions :-",TextAlignment.LEFT,true, false));
//        table.addCell(createCell(1,3,17,6,"* Pay school fee on time otherwise you will have to face penalty",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,20,19,"Guidelines and Admission Rules:-",TextAlignment.CENTER,false, false));
//        table.addCell(createCell(1,3,16,6,"* Note -Please read the detailed rules & regulations of the School carefully and sign it properly.",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* Daily attendance of student is very important for his/her education. A student must attend all his periods regularly. In case of any leave student must inform his/her class teacher prior a day before. If a student remains continuously absent for seven days without any information, his/her name would be struck off without any notice to parents.",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* School related information is updated on school app regularly. Parents must download school app for regular updates a sit is not possible for school management to provide updates on phone call",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* School gives admission to student on the basis of information provided by parents on cea student is enrolled in School parent must submit required documents immediately. No request will be accepted for change in particulars after enrolment of student in school SR register",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* School fees must be deposited before due date. If the fee is not deposited before due dateRs20 per day late fees fine will be imposed",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* Student’s Tuition fees and Van charges are non refundable. Fees once deposited will not be refunded in any case. ",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* The School session begins from1 April and concludes on 31 March of particular year.",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* Parents/Guardians are instructed to fill-in the admission forms without most accuracy. No changes will be permitted thereafter, for any reason whatsoever.",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* A transfer certificate is required for the child coming from another school",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* Transport fee for the entire year are to be paid in advance. Transport facility is available for full termonly and not on monthly basis.",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* In case Parents/Guardians have to change their contact number they are requested to update same in school office immediately.",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* Students are not allowed to use ornaments like earrings, bangles , anklet, rings  etc",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* Students are not allowed to come school by bike.",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* Students are not allowed to use electronic devices and mobiles . Ifanystudent is foundwith any item, his/her parents have to come in school.Without parents schoolwill  not return that item.",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* Student must come in complete school uniform",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* It is compulsory for  parents to come in PTM ( Parents Teacher Meeting )",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* School will not allow any leave to your child without your permission. So, please register your permanent mobile number.",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,16,6,"* In order to acquire proficiency in spoken English all students must converse in English in school",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,13,5,"Name : .........................",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,13,5,"Contact : .........................",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,3,13,5,"Address : .........................",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,2,13,5,"Relation with student : .........................",TextAlignment.LEFT,false, false));
//        table.addCell(createCell(1,1,13,5,"Sign",TextAlignment.LEFT,false, false));
//        document.add(table);
//        document.close();
//
//
//    }
    private static Cell createCell(int row, int col, int fontsize, int padding, String text,
                                   TextAlignment alignment, boolean bold, Boolean border) throws IOException {
        Cell cell = new Cell(row, col);
        cell.setVerticalAlignment(VerticalAlignment.TOP);
        cell.setTextAlignment(alignment);
        cell.setFontSize(fontsize);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

        cell.setFont(font);
        cell.add(new Paragraph(text));
        cell.setPaddingTop(padding);
        cell.setPaddingBottom(padding);
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        if (bold){
            cell.setBold();
        }
        if (!border){
            cell.setBorder(Border.NO_BORDER);
        }
        return cell;
    }

    private static Cell createCell(String imgUrl) throws IOException {
        Cell cell = createCell(4, 1, 20, 1, "", TextAlignment.LEFT, true, true);
        Image img = new Image(ImageDataFactory.create(new URL(imgUrl)));
        img.setAutoScale(true);
        cell.add(img);
        return cell;
    }
}
