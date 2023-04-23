package util;

import model.Address;
import model.Graduate;
import model.Score;
import model.Undergraduate;

import java.util.List;
import java.util.Scanner;

public class InPutStuInfo {
    // 输入本科生信息
    public static Undergraduate addUnderGraduate(int i) {
        Scanner sc = new Scanner(System.in);
        if (i + 1 == 1) {
            System.out.println("请输入第" + (i + 1) + "个本科生的信息，按照以下顺序以一个空格分隔：学号 姓名 年龄 班级 年级 专业 省份 城市 街道 地址 语文成绩 数学成绩 英语成绩");
        } else {
            System.out.println("请输入第" + (i + 1) + "个本科生的信息");
        }
        String[] input = sc.nextLine().split(" ");
        if (input.length != 13) {
            System.out.println("信息不完整或格式不正确");
            return null;
        }
        try {
            long number = Long.parseLong(input[0]);
            String name = input[1];
            int age = Integer.parseInt(input[2]);
            String grade = input[3];
            String className = input[4];
            String major = input[5];
            Address address = new Address(input[6], input[7], input[8], input[9]);
            double chinese = Double.parseDouble(input[10]);
            double math = Double.parseDouble(input[11]);
            double english = Double.parseDouble(input[12]);
            return new Undergraduate(number, name, age, address, className, grade, major, chinese, math, english);
        } catch (NumberFormatException e) {
            System.out.println("输入格式不正确");
            return null;
        }
    }


    // 输入研究生信息
    public static Graduate addGraduate(int i) {
        Scanner sc = new Scanner(System.in);
        if (i + 1 == 1) {
            System.out.println("请输入第" + (i + 1) + "个研究生的信息，按照以下顺序以一个空格分隔：学号 姓名 年龄 班级 导师 研究方向 省份 城市 街道 地址 语文成绩 数学成绩 英语成绩 历史成绩");
        } else {
            System.out.println("请输入第" + (i + 1) + "个研究生的信息");
        }
        String[] inputArr = sc.nextLine().split(" ");
        if (inputArr.length != 13) {
            System.out.println("信息不完整或格式不正确");
            return null;
        }
        try {
            int number = Integer.parseInt(inputArr[0]);
            String name = inputArr[1];
            int age = Integer.parseInt(inputArr[2]);
            String className = inputArr[3];
            Address address = new Address(inputArr[4], inputArr[5], inputArr[6], inputArr[7]);
            String tutor = inputArr[8];
            String researchDirection = inputArr[9];
            double math = Double.parseDouble(inputArr[10]);
            double english = Double.parseDouble(inputArr[11]);
            double history = Double.parseDouble(inputArr[12]);
            return new Graduate(number, name, age, address, className, tutor, researchDirection, math, english, history);
        } catch (NumberFormatException e) {
            System.out.println("输入格式错误");
            return null;
        }
    }


    // 修改本科生信息
    public static Undergraduate updateUnderGraduate(Undergraduate u) {
        String name, classNum, major;
        int age;
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("请选择您要修改的学生信息：");
            //姓名、年龄、班级、专业、地址、各科成绩
            System.out.println("1.姓名 2.年龄 3.班级 4.专业 5.地址 6.年级 7.各科成绩 0.退出");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("输入格式错误");
                return null;
            }
            switch (choice) {
                case 1:
                    System.out.println("请输入新的姓名：");
                    name = sc.next();
                    u.setName(name);
                    break;
                case 2:
                    System.out.println("请输入新的年龄：");
                    age = sc.nextInt();
                    u.setAge(age);
                    break;
                case 3:
                    System.out.println("请输入新的班级：");
                    classNum = sc.next();
                    u.setClassNum(classNum);
                    break;
                case 4:
                    System.out.println("请输入新的专业：");
                    major = sc.next();
                    u.setMajor(major);
                    break;
                case 5:
                    System.out.println("请输入新的地址：");
                    String[] addressArr = sc.next().split(" ");
                    if (addressArr.length != 4) {
                        System.out.println("输入地址格式错误");
                        return null;
                    }
                    Address address = new Address(addressArr[0], addressArr[1], addressArr[2], addressArr[3]);
                    u.setAddress(address);
                    break;
                case 6:
                    System.out.println("请输入新的年级：");
                    String grade = sc.next();
                    u.setGrade(grade);
                    break;
                case 7:
                    System.out.println("请输入新的各科成绩：");
                    Score[] scores = new Score[3];
                    scores[0] = new Score("Chinese", sc.nextDouble());
                    scores[1] = new Score("Math", sc.nextDouble());
                    scores[2] = new Score("English", sc.nextDouble());
                    u.setScores(List.of(scores));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
        return u;
    }

    // 修改研究生信息
    public static Graduate updateGraduate(Graduate g) {
        String name, classNum, advisor, researchDirection;
        int age;
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("请选择您要修改的学生信息：");
            //姓名、年龄、班级、导师、研究方向、地址、各科成绩
            System.out.println("1.姓名 2.年龄 3.班级 4.导师 5.研究方向 6.地址 7.各科成绩 0.退出");
            //判断输入是否为数字
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("输入错误，请重新输入！");
                sc.next();
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("请输入新的姓名：");
                    name = sc.next();
                    g.setName(name);
                    break;
                case 2:
                    System.out.println("请输入新的年龄：");
                    age = sc.nextInt();
                    g.setAge(age);
                    break;
                case 3:
                    System.out.println("请输入新的班级：");
                    classNum = sc.next();
                    g.setClassNum(classNum);
                    break;
                case 4:
                    System.out.println("请输入新的导师：");
                    advisor = sc.next();
                    g.setAdvisor(advisor);
                    break;
                case 5:
                    System.out.println("请输入新的研究方向：");
                    researchDirection = sc.next();
                    g.setResearchArea(researchDirection);
                    break;
                case 6:
                    System.out.println("请输入新的地址：");
                    String[] addressArr = sc.next().split(" ");
                    Address address = new Address(addressArr[0], addressArr[1], addressArr[2], addressArr[3]);
                    g.setAddress(address);
                    break;
                case 7:
                    System.out.println("请输入新的各科成绩：");
                    Score[] scores = new Score[3];
                    scores[0] = new Score("Math", sc.nextDouble());
                    scores[1] = new Score("English", sc.nextDouble());
                    scores[2] = new Score("History", sc.nextDouble());
                    g.setScores(List.of(scores));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
        return g;
    }
}



