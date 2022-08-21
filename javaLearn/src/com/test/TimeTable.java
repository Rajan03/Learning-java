package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTable {
    public static void main(String[] args) {
        System.out.println(tt());
    }

    public static List<Map<String, Object>> tt(){
        List<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("friday");
        days.add("saturday");

        List<String> periods = new ArrayList<>();
        periods.add("1");
        periods.add("2");
        periods.add("3");
        periods.add("4");
        periods.add("5");
        periods.add("6");
        periods.add("7");

        Map<String, Object> teacher = new HashMap<>();
        List<Map<String, Object>> periodsData = new ArrayList<>();
        teacher.put("name", "Anil");
        Map<String, Object> eachPeriod = new HashMap<>();
        eachPeriod.put("periodNo", 1);
        eachPeriod.put("subject", " ");
        eachPeriod.put("class", " ");
        periodsData.add(eachPeriod);
        eachPeriod.put("periodNo", 2);
        eachPeriod.put("subject", "Hindi");
        eachPeriod.put("class", "3rd");
        periodsData.add(eachPeriod);
        teacher.put("periods", periodsData);

        List<Map<String, Object>> dayWiseData = new ArrayList<>();

        for (String day : days){
            Map<String, Object> eachDay = new HashMap<>();
            eachDay.put("day", day);
            eachDay.put("periods", periods);
//            eachDay.put("teachers", teacher);
            dayWiseData.add(eachDay);
        }
        return dayWiseData;
    }
}
