package view;

import dao.GraduateDao;
import dao.UndergraduateDao;
import model.Graduate;
import model.Undergraduate;
import util.Cls;
import util.InPut;
import util.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class Operate {
    static Scanner scanner = new Scanner(System.in);
    static int id;
    static String name;
    static String className;

    // 增加学生
    public static void addStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        System.out.println("请选择您要增加的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        int type = scanner.nextInt();
        if (type == 1) {
            Undergraduate u = InPut.addUnderGraduate();
            if (u != null) {
                undergraduateDao.add(u);
            }
        } else if (type == 2) {
            Graduate g = InPut.addGraduate();
            if (g != null) {
                graduateDao.add(g);
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
    }

    // 修改学生
    public static void updateStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        System.out.println("请选择您要修改的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        int type2 = scanner.nextInt();
        scanner.nextLine();// 吃掉回车
        if (type2 == 1) {
            System.out.println("请输入您要修改的学生学号：");
            id = scanner.nextInt();

            if (undergraduateDao.queryById(id) != null) {
                System.out.println(Table.getHeaderByUnGraduate());
                System.out.println(Table.getRowByUnGraduate(undergraduateDao.queryById(id)));
                Undergraduate new_u = InPut.updateUnderGraduate(undergraduateDao.queryById(id));
                undergraduateDao.modify(id, new_u);
                System.out.println(Table.getHeaderByUnGraduate());
                System.out.println(Table.getRowByUnGraduate(undergraduateDao.queryById(id)));
            } else {
                System.out.println("学号不存在");
            }
        } else if (type2 == 2) {
            System.out.println("请输入您要修改的学生学号：");
            id = scanner.nextInt();
            if (graduateDao.queryById(id) != null) {
                System.out.println(Table.getHeaderByGraduate());
                System.out.println(Table.getRowByGraduate(graduateDao.queryById(id)));
                Graduate new_G = InPut.updateGraduate(graduateDao.queryById(id));
                graduateDao.modify(id, new_G);
                System.out.println(Table.getHeaderByGraduate());
                System.out.println(Table.getRowByGraduate(graduateDao.queryById(id)));
            } else {
                System.out.println("学号不存在");
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
    }

    // 删除学生
    public static void deleteStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        System.out.println("请选择您要删除的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        int type3 = scanner.nextInt();
        if (type3 == 1) {
            System.out.println("请输入您要删除的学生学号：");
            id = scanner.nextInt();
            if (undergraduateDao.queryById(id) != null) {
                System.out.println(Table.getHeaderByUnGraduate());
                System.out.println(Table.getRowByUnGraduate(undergraduateDao.queryById(id)));
                undergraduateDao.delete(id);
            }
        } else if (type3 == 2) {
            System.out.println("请输入您要删除的学生学号：");
            id = scanner.nextInt();
            if (graduateDao.queryById(id) != null) {
                System.out.println(Table.getHeaderByGraduate());
                System.out.println(Table.getRowByGraduate(graduateDao.queryById(id)));
                graduateDao.delete(id);
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
    }

    // 浏览学生
    public static void browseStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        System.out.println("请选择您要浏览的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        int type4 = scanner.nextInt();
        if (type4 == 1) {
            ArrayList<Undergraduate> us = undergraduateDao.queryAll();
            System.out.println(Table.getHeaderByUnGraduate());
            for (Undergraduate u : us) {
                System.out.println(Table.getRowByUnGraduate(u));
            }
        } else if (type4 == 2) {
            ArrayList<Graduate> gs = graduateDao.queryAll();
            System.out.println(Table.getHeaderByGraduate());
            for (Graduate g : gs) {
                System.out.println(Table.getRowByGraduate(g));
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
    }

    // 查询学生
    public static void queryStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        System.out.println("请选择您要查询的学生类型：");
        System.out.println("1. 研究生" + "\t" + "2. 本科生");
        int type5 = scanner.nextInt();
        if (type5 == 1) {
            System.out.println("请选择您要查询的方式：");
            System.out.println("1. 按姓名查询" + "\t" + "2. 按学号查询" + "\t" + "3. 按班级查询");
            int type6 = scanner.nextInt();
            scanner.nextLine(); // consume end-of-line character
            if (type6 == 1) {
                System.out.print("请输入学生姓名：");
                name = scanner.nextLine();
                if (graduateDao.queryByName(name) == null) {
                    return;
                }
                System.out.println(Table.getHeaderByGraduate());
                System.out.println(Table.getRowByGraduate(graduateDao.queryByName(name)));
            } else if (type6 == 2) {
                System.out.print("请输入学生学号：");
                id = scanner.nextInt();
                if (graduateDao.queryById(id) == null) {
                    return;
                }
                System.out.println(Table.getHeaderByGraduate());
                System.out.println(Table.getRowByGraduate(graduateDao.queryById(id)));
            } else if (type6 == 3) {
                System.out.print("请输入学生班级：");
                className = scanner.nextLine();
                if (graduateDao.queryByClass(className) == null) {
                    return;
                }
                System.out.println(Table.getHeaderByGraduate());
                ArrayList<Graduate> gs = graduateDao.queryByClass(className);
                for (Graduate g : gs) {
                    System.out.println(Table.getRowByGraduate(g));
                }
            } else {
                System.out.println("输入有误，请重新输入");
            }
        } else if (type5 == 2) {
            System.out.println("请选择您要查询的方式：");
            System.out.println("1. 按姓名查询" + "\t" + "2. 按学号查询" + "\t" + "3. 按班级查询");
            int type6 = scanner.nextInt();
            scanner.nextLine(); // consume end-of-line character
            if (type6 == 1) {
                System.out.print("请输入学生姓名：");
                name = scanner.nextLine();
                if (undergraduateDao.queryByName(name) == null) {
                    return;
                }
                System.out.println(Table.getHeaderByUnGraduate());
                System.out.println(Table.getRowByUnGraduate(undergraduateDao.queryByName(name)));
            } else if (type6 == 2) {
                System.out.print("请输入学生学号：");
                id = scanner.nextInt();
                if (undergraduateDao.queryById(id) == null) {
                    return;
                }
                System.out.println(Table.getHeaderByUnGraduate());
                System.out.println(Table.getRowByUnGraduate(undergraduateDao.queryById(id)));
            } else if (type6 == 3) {
                System.out.print("请输入学生班级：");
                className = scanner.nextLine();
                if (undergraduateDao.queryByClass(className) == null) {
                    return;
                }
                System.out.println(Table.getHeaderByUnGraduate());
                ArrayList<Undergraduate> us = undergraduateDao.queryByClass(className);
                for (Undergraduate u : us) {
                    System.out.println(Table.getRowByUnGraduate(u));
                }
            } else {
                System.out.println("输入有误，请重新输入");
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
    }

    // 排序学生
    public static void sortStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        System.out.println("请选择您要排序的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        int type7 = scanner.nextInt();
        if (type7 == 1) {
            System.out.println("请选择您要排序的方式：");
            System.out.println("1. 按姓名排序" + "\t" + "2. 按学号排序" + "\t" + "3. 按语文成绩排序" + "\t" + "4. 按数学成绩排序" + "\t" + "5. 按英语成绩排序" + "\t" + "6. 按总成绩排序");
            int type8 = scanner.nextInt();
            scanner.nextLine(); // consume end-of-line character
            if (type8 == 1) {
                undergraduateDao.sortByName();
            } else if (type8 == 2) {
                undergraduateDao.sortByStudentNum();
            } else if (type8 == 3) {
                UndergraduateDao.sortBySubject("Chinese");
            } else if (type8 == 4) {
                UndergraduateDao.sortBySubject("Math");
            } else if (type8 == 5) {
                UndergraduateDao.sortBySubject("English");
            } else if (type8 == 6) {
                UndergraduateDao.sortByTotalScore();
            } else {
                System.out.println("输入有误，请重新输入");
            }
        } else if (type7 == 2) {
            System.out.println("请选择您要排序的方式：");
            System.out.println("1. 按姓名排序" + "\t" + "2. 按学号排序" + "\t" + "3. 按数学成绩排序" + "\t" + "4. 按英语成绩排序" + "\t" + "5. 按历史成绩排序" + "\t" + "6. 按总成绩排序");
            int type8 = scanner.nextInt();
            if (type8 == 1) {
                graduateDao.sortByName();
            } else if (type8 == 2) {
                graduateDao.sortByStudentNum();
            } else if (type8 == 3) {
                GraduateDao.sortBySubject("Math");
            } else if (type8 == 4) {
                GraduateDao.sortBySubject("English");
            } else if (type8 == 5) {
                GraduateDao.sortBySubject("History");
            } else if (type8 == 6) {
                GraduateDao.sortByTotalScore();
            } else {
                System.out.println("输入有误，请重新输入");
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
    }
}
