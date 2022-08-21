package main.java;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class BdayCalender {

    // private static final Logger logger = LoggerFactory.getLogger(ExportTodayBirthday.class);

//    public List<Map<String, Object>> getData(Map<String, Object> params) {
//        String where = "(st.deactivated = false or st.deactivated is null ) and DATE_FORMAT(sp.dob,'%m-%d')>= DATE_FORMAT(:dob_start,'%m-%d') and DATE_FORMAT(sp.dob,'%m-%d')<= DATE_FORMAT(:dob_end,'%m-%d') and st.academic_session_pk=:academic_session_pk and st.branch_pk=:branch_pk";
//        if (params.get("class_pk") != null) {
//            where = where + " and s.class_pk=" + params.get("class_pk");
//        }
//        SelectStatement birthdayList = new SelectStatement()
//                .select("a.name as class_incharge,DATE_FORMAT(sp.dob,'%M') as month_name,st.pk,b.name as branch_name,sp.discontinue_date,sp.discontinue_remarks,sp.user_pk, sp.discontinue_by,stp.first_name as staff_first_name,stp.last_name as staff_last_name,sp.image_info_ as image, st.admission_no as registeration_no,sp.dob,sp.first_name,sp.name, sp.last_name,sp.gender,sp.father_name,sp.mobile,sec.name as section_name, c.name as class_name")
//                .from("ssms_students st inner join ssms_profile b on b.pk=st.branch_pk INNER JOIN ssms_student_profiles sp on sp.pk = st.student_profile_pk INNER JOIN ssms_academic_sessions AS asn ON asn.pk = st.academic_session_pk INNER JOIN ssms_sections AS sec ON sec.pk = st.section_pk left join ssms_staff_profiles a on a.pk =sec.incharge_pk INNER JOIN ssms_classes AS c ON c.pk=sec.class_pk LEFT JOIN ssms_staff_profiles as stp on stp.pk=sp.discontinue_by ")
//                .where(where)
//                .orderBy("DATE_FORMAT(sp.dob,'%m-%d'),c.`index`,sec.name,sp.first_name,sp.last_name")
//                .addParameter("academic_session_pk", params.get("academic_session_pk"))
//                .addParameter("branch_pk", "#Current_Branch_Pk")
//                .addParameter("dob_start", params.get("dob_start"))
//                .addParameter("dob_end", params.get("dob_end"));
//        List<Map<String, Object>> todaybirthdayList = birthdayList.execute();
//        logger.debug(todaybirthdayList + "todaybirthdayList");
//        return todaybirthdayList;
//    }
//    public void print(Map<String, Object> params) throws IOException, SQLException, java.text.ParseException, org.json.simple.parser.ParseException, DocumentException {
//        CurrentRequest.response().setContentType("application/pdf");
//
//        List<Map<String, Object>> todaybirthdayList = getData(params);
//        List<String> days = new ArrayList<>();
//        days.add("Sunday\n");
//        days.add("Monday\n");
//        days.add("Tuesday\n");
//        days.add("Wednesday\n");
//        days.add("Thursday\n");
//        days.add("Friday\n");
//        days.add("Saturday\n");
//
//        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(CurrentRequest.response().getOutputStream()));
//
//        URL imgUrl = new URL("https://cdn.pixabay.com/photo/2016/01/30/14/15/happy-birthday-1169669__340.png");
//        pdfDocument.addEventHandler(PdfDocumentEvent.START_PAGE, new BackgroundEventHandler(imgUrl));
//
//        Document document = new Document(pdfDocument, PageSize.A4.rotate(), true);
//        document.setMargins(0,4,4,4);
//
//        Table table = new Table(UnitValue.createPercentArray(new float[]{20,30,30,20}));
//        table.useAllAvailableWidth();
//
//        Cell img = new Cell();
//        Image cellImg = new Image(ImageDataFactory.create(new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxir"  +
//                "5UufwgZLkODnwfvGC5v_fBZrPiXH3F6w&usqp=CAU")));
//        cellImg.setMaxHeight(70);
//        img.setBorder(Border.NO_BORDER);
//        cellImg.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        img.add(cellImg);
//        table.addCell(img);
//
//        Cell cell = createCell(
//                new DeviceRgb(29,53,83)
//        );
//        PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
//        cell.setFont(font);
//        cell.setUnderline();
//        table.addCell(cell);
//        img = new Cell();
//        img.setBorder(Border.NO_BORDER);
//        cellImg.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        img.add(cellImg);
//        table.addCell(img);
//        document.add(table);
//
//        table = new Table(UnitValue.createPercentArray(new float[]{14,14,14,14,14,14,14}));
//        table.useAllAvailableWidth();
//        table.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
//        table.setVerticalBorderSpacing(17);
//        table.setHorizontalBorderSpacing(9);
//        for (String day : days){
//            table.addCell(createCell(9, 25,20,2,day,
//                    new DeviceRgb(255,255,255),new DeviceRgb(29,53,83), TextAlignment.CENTER, true));
//        }
//        int startDay = LocalDate.now().getDayOfWeek().getValue();
//        for (int j = 1; j <= startDay; j++){
//            table.addCell(createCell(9, 25,20,2,"",
//                    new DeviceRgb(29,53,83),new DeviceRgb(245,245,255),TextAlignment.CENTER, true));
//        }
//
//        int daysInCurrentMonth = LocalDate.now().lengthOfMonth();
//        for (int i = 1; i <= daysInCurrentMonth; i++){
//            table.addCell(createCell(String.valueOf(i),
//                    new DeviceRgb(29,53,83),new DeviceRgb(245,245,255), todaybirthdayList));
//        }
//        document.add(table);
//        document.close();
//    }
//   private static Cell createCell(int fontsize, int maxWidth, int minHeight, int wordSpacing, String text,
//                                   DeviceRgb fontColor, DeviceRgb bgColor, TextAlignment alignment,
//                                   boolean bold){
//        Cell cell = new Cell();
//        cell.setPadding(5);
//        cell.setMaxWidth(maxWidth);
//        cell.setMinHeight(minHeight);
//        cell.setVerticalAlignment(VerticalAlignment.TOP);
//        cell.setTextAlignment(alignment);
//        cell.setBackgroundColor(bgColor);
//        cell.setFontColor(fontColor);
//        cell.setFontSize(fontsize);
//        cell.add(new Paragraph(text));
//        cell.setCharacterSpacing(wordSpacing);
//        if (bold){
//            cell.setBold();
//        }
//        cell.setBorder(Border.NO_BORDER);
//        return cell;
//    }
//    private static Cell createCell(String text, DeviceRgb fontColor, DeviceRgb bgColor, List<Map<String, Object>> students)
//            throws MalformedURLException {
//        Cell cell = createCell(10, 40, 62, 1, text, fontColor, bgColor,
//                TextAlignment.LEFT, false);
//        cell.add(studentTable(students));
//        return cell;
//    }
//    private static Cell createCell(DeviceRgb fontColor){
//        Cell cell = new Cell(1,2);
//        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        cell.setFontColor(fontColor);
//        cell.setFontSize(24);
//        cell.add(new Paragraph("Birthday Calenders "+ "("+LocalDate.now().getMonth()+ ")"));
//        cell.setCharacterSpacing(3);
//        cell.setBold();
//        cell.setBorder(Border.NO_BORDER);
//        return cell;
//    }
//    private static Table studentTable(List<Map<String, Object>> students) throws MalformedURLException {
//        Table table = new Table(UnitValue.createPercentArray(new float[]{75,25}));
//        table.useAllAvailableWidth();
//        for (Map<String, Object> student:students){
//            Cell studentCell = new Cell();
//            studentCell.add(new Paragraph(student.get("name") + " " + student.get("class_name")));
//            studentCell.setFontSize(9);
//            studentCell.setBorder(Border.NO_BORDER);
//            studentCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
//            studentCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
//            studentCell.setBold();
//            table.addCell(studentCell);
//            studentCell = new Cell();
//            Image stdnt = new Image(ImageDataFactory.create(new URL(student.get("image").toString())));
//            studentCell.setBorder(Border.NO_BORDER);
//            stdnt.setHorizontalAlignment(HorizontalAlignment.CENTER);
//            studentCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
//            stdnt.setMaxHeight(20);
//            studentCell.add(stdnt);
//            table.addCell(studentCell);
//        }
//        return table;
//    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        int days = LocalDate.now().lengthOfMonth();
        LocalDate end = LocalDate.now().withDayOfMonth(days);
        System.out.println(start + "  "+end);
    }
}