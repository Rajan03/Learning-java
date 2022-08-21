package main.java;

import java.util.*;

public class PtmAttendance {

    public static void main(String[] args) {
        List<Map<String, String>> reportData = new ArrayList<>();
        Map<String, String> eachClassReport = new HashMap<>();
        public LinkedHashSet<String> header() {
            LinkedHashSet<String> rowName = new LinkedHashSet<>();
            rowName.add("Class");
            rowName.add("Attendance Taken On");
            rowName.add("Total Students");
            rowName.add("Not Marked");
            rowName.add("P");
            rowName.add("A");
            rowName.add("Per(%)");
            rowName.add("Absent Students");
            return rowName;
        }
    }
}
