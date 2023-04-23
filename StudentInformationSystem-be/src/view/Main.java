package view;

import dao.GraduateDao;
import dao.UndergraduateDao;
import util.Cls;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GraduateDao graduateDao = new GraduateDao();
        UndergraduateDao undergraduateDao = new UndergraduateDao();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            UI.menu();
            if (scanner.hasNextInt()) { // 判断输入是否为整数
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> Operate.addStu(undergraduateDao, graduateDao);

                    case 2 -> Operate.updateStu(undergraduateDao, graduateDao);

                    case 3 -> Operate.deleteStu(undergraduateDao, graduateDao);

                    case 4 -> Operate.browseStu(undergraduateDao, graduateDao);

                    case 5 -> Operate.queryStu(undergraduateDao, graduateDao);

                    case 6 -> Operate.sortStu(undergraduateDao, graduateDao);

                    case 7 -> {
                        Cls.cls();
                        System.out.println("本科生人数：" + undergraduateDao.getSize());
                    }
                    case 8 -> {
                        Cls.cls();
                        System.out.println("研究生人数：" + graduateDao.getSize());
                    }
                    case 9 -> {
                        Cls.cls();
                        System.out.println("所有学生人数：" + (undergraduateDao.getSize() + graduateDao.getSize()));
                    }
                    case 0 -> System.out.println("退出系统");
                    default -> System.out.println("输入错误，请重新输入！");
                }
            } else {
                System.out.println("输入错误，请输入整数！");
                scanner.next(); // 清空输入缓冲区
            }
        }
    }
}


