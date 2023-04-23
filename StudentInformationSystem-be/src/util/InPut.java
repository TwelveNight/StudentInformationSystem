package util;

import model.Address;
import model.Graduate;
import model.Score;
import model.Undergraduate;

import java.util.List;
import java.util.Scanner;

public class InPut {
    // 输入本科生信息
    public static Undergraduate addUnderGraduate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入本科生的信息:");
        System.out.print("学号: ");
        int number = sc.nextInt();
        sc.nextLine();// 吃掉回车
        System.out.print("姓名: ");
        String name = sc.nextLine();
        System.out.print("年龄: ");
        int age = sc.nextInt();
        sc.nextLine();// 吃掉回车
        System.out.print("班级: ");
        String className = sc.nextLine();
        System.out.print("年级:");
        String grade = sc.nextLine();
        System.out.print("专业:");
        String major = sc.nextLine();
        System.out.print("地址 (省份 城市 街道 地址): ");
        String[] addressArr = sc.nextLine().split(" ");
        if (addressArr.length != 4) {
            System.out.println("输入地址格式错误");
            return null;
        }
        Address address = new Address(addressArr[0], addressArr[1], addressArr[2], addressArr[3]);
        System.out.print("成绩 (语文 数学 英语): ");
        double chinese = sc.nextDouble();
        double math = sc.nextDouble();
        double english = sc.nextDouble();
        return new Undergraduate(number, name, age, address, className, grade, major, chinese, math, english);
    }

    // 输入研究生信息
    public static Graduate addGraduate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入研究生的信息:");
        System.out.print("学号: ");
        int number = sc.nextInt();
        sc.nextLine();// 吃掉回车
        System.out.print("姓名: ");
        String name = sc.nextLine();
        System.out.print("年龄: ");
        int age = sc.nextInt();
        sc.nextLine();// 吃掉回车
        System.out.print("班级: ");
        String className = sc.nextLine();
        System.out.print("地址 (省份 城市 街道 地址): ");
        String[] addressArr = sc.nextLine().split(" ");
        if (addressArr.length != 4) {
            System.out.println("输入地址格式错误");
            return null;
        }
        Address address = new Address(addressArr[0], addressArr[1], addressArr[2], addressArr[3]);
        System.out.print("导师: ");
        String tutor = sc.nextLine();
        System.out.print("研究方向: ");
        String researchDirection = sc.nextLine();
        System.out.print("成绩 (数学 英语 历史): ");
        double math = sc.nextDouble();
        double english = sc.nextDouble();
        double history = sc.nextDouble();
        return new Graduate(number, name, age, address, className, tutor, researchDirection, math, english, history);
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
            System.out.println("1.姓名 2.年龄 3.班级 4.专业 5.地址 6.各科成绩 0.退出");
            choice = sc.nextInt();
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
            choice = sc.nextInt();
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



