package util;

import model.Graduate;
import model.Undergraduate;

import java.util.Scanner;

public class IO {
    // 输入本科生信息
    public static Undergraduate inputUndergraduateInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入本科生的信息:");
        System.out.print("学号: ");
        String number = sc.nextLine();
        System.out.print("姓名: ");
        String name = sc.nextLine();
        System.out.print("年龄: ");
        String age = sc.nextLine();
        sc.nextLine(); // 读取回车符
        System.out.print("班级: ");
        String className = sc.nextLine();
        System.out.println("年级:");
        String grade = sc.nextLine();
        System.out.println("专业:");
        String major = sc.nextLine();
        System.out.print("地址 (省份 城市 街道 地址): ");
        String[] addressArr = sc.nextLine().split(" ");
        Address address = new Address(addressArr[0], addressArr[1], addressArr[2], addressArr[3]);
        System.out.print("成绩 (语文 数学 英语): ");
        Score[] scores = new Score[3];
        scores[0] = new Score("语文", sc.nextDouble());
        scores[1] = new Score("数学", sc.nextDouble());
        scores[2] = new Score("英语", sc.nextDouble());
        return new Undergraduate(number, name, age, address, scores, className, grade, major, scores[0].getGrade(), scores[1].getGrade(), scores[2].getGrade());
    }

    // 输入研究生信息
    public static Graduate inputGraduateInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入研究生的信息:");
        System.out.print("学号: ");
        String number = sc.nextLine();
        System.out.print("姓名: ");
        String name = sc.nextLine();
        System.out.print("年龄: ");
        String age = sc.nextLine();
        sc.nextLine(); // 读取回车符
        System.out.print("班级: ");
        String className = sc.nextLine();
        System.out.print("地址 (省份 城市 街道 地址): ");
        String[] addressArr = sc.nextLine().split(" ");
        Address address = new Address(addressArr[0], addressArr[1], addressArr[2], addressArr[3]);
        System.out.print("导师: ");
        String tutor = sc.nextLine();
        System.out.print("研究方向: ");
        String researchDirection = sc.nextLine();
        System.out.print("成绩 (语文 数学 英语): ");
        Score[] scores = new Score[3];
        scores[0] = new Score("语文", sc.nextDouble());
        scores[1] = new Score("数学", sc.nextDouble());
        scores[2] = new Score("英语", sc.nextDouble());
        return new Graduate(number, name, age, address, scores, className, tutor, researchDirection, scores[0].getGrade(), scores[1].getGrade(), scores[2].getGrade());
    }

    //格式化输出本科生信息
    public static void printUndergraduateInfo(Undergraduate undergraduate) {
        System.out.println("学号: " + undergraduate.getId());
        System.out.println("姓名: " + undergraduate.getName());
        System.out.println("年龄: " + undergraduate.getAge());
        System.out.println("年级: " + undergraduate.getGrade());
        System.out.println("班级: " + undergraduate.getClassNum());
        System.out.println("专业: " + undergraduate.getMajor());
        System.out.println("地址: " + undergraduate.getAddress().getProvince() + " " + undergraduate.getAddress().getCity() + " " + undergraduate.getAddress().getStreet() + " " + undergraduate.getAddress());
        System.out.println("成绩: ");
        for (Score score : undergraduate.getScores()) {
            System.out.println(score.getCourseName() + ": " + score.getGrade());
        }
    }

    //格式化输出研究生信息
    public static void printGraduateInfo(Graduate graduate) {
        System.out.println("学号: " + graduate.getId());
        System.out.println("姓名: " + graduate.getName());
        System.out.println("年龄: " + graduate.getAge());
        System.out.println("班级: " + graduate.getClassNum());
        System.out.println("导师: " + graduate.getAdvisor());
        System.out.println("研究方向: " + graduate.getResearchArea());
        System.out.println("地址: " + graduate.getAddress().getProvince() + " " + graduate.getAddress().getCity() + " " + graduate.getAddress().getStreet() + " " + graduate.getAddress());
        System.out.println("成绩: ");
        for (Score score : graduate.getScores()) {
            System.out.println(score.getCourseName() + ": " + score.getGrade());
        }
    }

    //格式化输出所有本科生信息
    public static void printAllUndergraduateInfo(Undergraduate[] undergraduates) {
        for (Undergraduate undergraduate : undergraduates) {
            printUndergraduateInfo(undergraduate);
            System.out.println();
        }
    }

}
