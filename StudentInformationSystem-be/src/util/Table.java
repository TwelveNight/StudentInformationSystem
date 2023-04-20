package Test;

import model.Graduate;
import model.Undergraduate;
import util.Address;
import util.Score;

import java.util.Objects;

public class TableHeader {
    private static final int ID_WIDTH = 20;
    private static final int NAME_WIDTH = 15;
    private static final int AGE_WIDTH = 10;
    private static final int GRADE_WIDTH = 10;
    private static final int CLASS_WIDTH = 10;
    private static final int MAJOR_WIDTH = 10;
    private static final int ADDRESS_WIDTH = 50;
    private static final int SCORE_WIDTH = 20;

    private static final int ADVISOR_WIDTH = 10;

    private static final int researchArea_WIDTH = 20;

    private static final String ID_HEADER = "ID";//学号
    private static final String NAME_HEADER = "Name";//姓名
    private static final String AGE_HEADER = "Age";//年龄
    private static final String GRADE_HEADER = "Grade";//年级
    private static final String CLASS_HEADER = "Class";//班级
    private static final String MAJOR_HEADER = "Major";//专业

    private static final String ADVISOR_HEADER = "Advisor";//导师

    private static final String RESEARCH_AREA_HEADER = "Research Area";//研究方向
    private static final String ADDRESS_HEADER = "Address";//地址
    private static final String SCORE_HEADER = "Math English History";//成绩


    //居中
    public static String centerText(String text, int width) {
        if (text == null) {
            text = "";
        }
        int padding = width - text.length();
        if (padding <= 0) {
            return text;
        } else {
            int leftPadding = padding / 2;
            int rightPadding = padding - leftPadding;
            return String.format("%s%s%s", " ".repeat(leftPadding), text, " ".repeat(rightPadding));
        }
    }

    //表头
    public static String getHeaderByUnGraduate() {
        return String.format("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
                centerText(ID_HEADER, ID_WIDTH),//学号
                centerText(NAME_HEADER, NAME_WIDTH),//姓名
                centerText(AGE_HEADER, AGE_WIDTH),//年龄
                centerText(GRADE_HEADER, GRADE_WIDTH),//年级
                centerText(CLASS_HEADER, CLASS_WIDTH),//班级
                centerText(MAJOR_HEADER, MAJOR_WIDTH),//专业
                centerText(ADDRESS_HEADER, ADDRESS_WIDTH),//地址
                centerText(SCORE_HEADER, SCORE_WIDTH));//成绩
    }

    //表格
    public static String getRowByUnGraduate(Undergraduate undergraduate) {
        return String.format("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
                centerText(Objects.toString(undergraduate.getId(), ""), ID_WIDTH),
                centerText(Objects.toString(undergraduate.getName(), ""), NAME_WIDTH),
                centerText(Objects.toString(undergraduate.getAge(), ""), AGE_WIDTH),
                centerText(Objects.toString(undergraduate.getGrade(), ""), GRADE_WIDTH),
                centerText(Objects.toString(undergraduate.getClassNum(), ""), CLASS_WIDTH),
                centerText(Objects.toString(undergraduate.getMajor(), ""), MAJOR_WIDTH),
                centerText(Objects.toString(undergraduate.getAddress(), ""), ADDRESS_WIDTH),
                centerText(Objects.toString(undergraduate.printScores(), ""), SCORE_WIDTH));
    }

    public static String getHeaderByGraduate() {
        return String.format("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
                centerText(ID_HEADER, ID_WIDTH),//学号
                centerText(NAME_HEADER, NAME_WIDTH),//姓名
                centerText(AGE_HEADER, AGE_WIDTH),//年龄
                centerText(CLASS_HEADER, CLASS_WIDTH),//班级
                centerText(ADVISOR_HEADER, ADVISOR_WIDTH),//导师
                centerText(RESEARCH_AREA_HEADER, researchArea_WIDTH),//研究方向
                centerText(ADDRESS_HEADER, ADDRESS_WIDTH),//地址
                centerText(SCORE_HEADER, SCORE_WIDTH));//成绩
    }

    public static String getRowByGraduate(Graduate graduate) {
        return String.format("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
                centerText(Objects.toString(graduate.getId(), ""), ID_WIDTH),//学号
                centerText(Objects.toString(graduate.getName(), ""), NAME_WIDTH),//姓名
                centerText(Objects.toString(graduate.getAge(), ""), AGE_WIDTH),//年龄
                centerText(Objects.toString(graduate.getClassNum(), ""), CLASS_WIDTH),//班级
                centerText(Objects.toString(graduate.getAdvisor(), ""), ADVISOR_WIDTH),//导师
                centerText(Objects.toString(graduate.getResearchArea(), ""), researchArea_WIDTH),//研究方向
                centerText(Objects.toString(graduate.getAddress(), ""), ADDRESS_WIDTH),//地址
                centerText(Objects.toString(graduate.printScores(), ""), SCORE_WIDTH));//成绩
    }

    public static void main(String[] args) {
        Score[] score = new Score[3];
        score[0] = new Score("ch", 100);
        score[1] = new Score("ma", 100);
        score[2] = new Score("en", 100);
        Address address = new Address("California", "Los_Angeles", "Wilshire_Boulevard", "100");
        Undergraduate undergraduate = new Undergraduate("2323156498", "z", "20", address, score, "2212", "1", "II", 44.0, 55, 66);
        System.out.print(TableHeader.getHeaderByUnGraduate());
        System.out.print(TableHeader.getRowByUnGraduate(undergraduate));

        Graduate graduate = new Graduate("2323156498", "z", "20", address, score, "2212", "Lily", "computer_science", 44.0, 55, 66);
        System.out.print(TableHeader.getHeaderByGraduate());
        System.out.print(TableHeader.getRowByGraduate(graduate));
    }
}


