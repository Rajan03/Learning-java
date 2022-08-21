import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeritList {

    public static void main(String[] args) throws IOException {

        List<String> headers = new ArrayList<String>();
        headers.add("Reg. No.");
        headers.add("Name");
        headers.add("Mob. No.");
        headers.add("English");
        headers.add("Hindi");
        headers.add("Total");
        headers.add("Status");

        List<Map<String, Object>> students = new ArrayList<Map<String, Object>>();
        Map<String, Object> student = new HashMap<String, Object>();
        student.put("RegNo", "5");
        student.put("Name", "Rajat");
        student.put("Mob", "2345678");
        student.put("English", "9");
        student.put("Hindi", "8");
        student.put("Total", "17");
        student.put("status", "done");
        students.add(student);

        student = new HashMap<String, Object>();
        student.put("RegNo", "15");
        student.put("Name", "Rayat");
        student.put("Mob", "9876543");
        student.put("English", "7");
        student.put("Hindi", "6");
        student.put("Total", "13");
        student.put("status", "not done");
        students.add(student);

        student = new HashMap<String, Object>();
        student.put("RegNo", "5");
        student.put("Name", "Rajat");
        student.put("Mob", "2345678");
        student.put("English", "9");
        student.put("Hindi", "8");
        student.put("Total", "17");
        student.put("status", "done");
        students.add(student);

        print(students,headers);
    }
    public static void print(List<Map<String, Object>> students, List<String> headers) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Merit List");
        int rowIndex = 0;
        Font font = workbook.createFont();
        XSSFRow row = sheet.createRow(rowIndex);
        XSSFCell cell = row.createCell(rowIndex);
        CellRangeAddress cellRangeAddress = new CellRangeAddress(rowIndex, rowIndex, 0, 7);
        sheet.addMergedRegion(cellRangeAddress);
        font.setFontHeightInPoints((short) 30);
        row.setHeight((short) 800);
        HorizontalAlignment centre = HorizontalAlignment.CENTER;

        cell.setCellValue(true);
        CellStyle cellStyle = row.getSheet().getWorkbook().createCellStyle();
        font.setBold(true);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFont(font);
        cellStyle.setAlignment(centre);
        cell.setCellStyle(cellStyle);

        FileOutputStream fileOutputStream = new FileOutputStream("meritlist.xls");
        workbook.write(fileOutputStream);
        System.out.println("File created");
    }
}
