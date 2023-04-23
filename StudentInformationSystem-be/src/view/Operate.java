package view;

import dao.GraduateDao;
import dao.UndergraduateDao;
import model.Graduate;
import model.UnderGraduate;
import util.Cls;
import util.InPutStuInfo;
import util.OutPutStuInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class Operate {
    static Scanner scanner = new Scanner(System.in);
    static long id;
    static String name;
    static String className;

    // 增加学生
    public static void addStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        int type = 0;
        System.out.println("请选择您要增加的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        if (scanner.hasNextInt()) {
            type = scanner.nextInt();
        } else {
            System.out.println("输入有误，请重新输入");
            scanner.next();
        }
        if (type == 1) {
            System.out.println("请输入要增加的本科生人数：");
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    UnderGraduate u = InPutStuInfo.addUnderGraduate(i);
                    if (u != null) {
                        undergraduateDao.add(u);
                    }
                }
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
        } else if (type == 2) {
            System.out.println("请输入要增加的研究生人数：");
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    Graduate g = InPutStuInfo.addGraduate(i);
                    if (g != null) {
                        graduateDao.add(g);
                    }
                }
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
        System.out.println("按任意键继续");
        scanner.nextLine();
        scanner.nextLine();
    }

    // 修改学生
    public static void updateStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        int type2 = 0;
        System.out.println("请选择您要修改的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        if (scanner.hasNextInt()) {
            type2 = scanner.nextInt();
        } else {
            System.out.println("输入有误，请重新输入");
            scanner.next();
        }
        scanner.nextLine();// 吃掉回车
        if (type2 == 1) {
            System.out.println("请输入您要修改的学生学号：");
            if (scanner.hasNextLong()) {
                id = scanner.nextLong();
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
            if (undergraduateDao.queryById(id) != null) {
                System.out.println(OutPutStuInfo.getHeaderByUnGraduate());
                System.out.println(OutPutStuInfo.getRowByUnGraduate(undergraduateDao.queryById(id)));
                UnderGraduate new_u = InPutStuInfo.updateUnderGraduate(undergraduateDao.queryById(id));
                undergraduateDao.modify(id, new_u);
                System.out.println(OutPutStuInfo.getHeaderByUnGraduate());
                System.out.println(OutPutStuInfo.getRowByUnGraduate(undergraduateDao.queryById(id)));
            } else {
                System.out.println("学号不存在");
            }
        } else if (type2 == 2) {
            System.out.println("请输入您要修改的学生学号：");
            if (scanner.hasNextLong()) {
                id = scanner.nextLong();
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
            if (graduateDao.queryById(id) != null) {
                System.out.println(OutPutStuInfo.getHeaderByGraduate());
                System.out.println(OutPutStuInfo.getRowByGraduate(graduateDao.queryById(id)));
                Graduate new_G = InPutStuInfo.updateGraduate(graduateDao.queryById(id));
                graduateDao.modify(id, new_G);
                System.out.println(OutPutStuInfo.getHeaderByGraduate());
                System.out.println(OutPutStuInfo.getRowByGraduate(graduateDao.queryById(id)));
            } else {
                System.out.println("学号不存在");
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
        System.out.println("按任意键继续");
        scanner.nextLine();
        scanner.nextLine();
    }

    // 删除学生
    public static void deleteStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        int type3 = 0;
        System.out.println("请选择您要删除的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        if (scanner.hasNextInt()) {
            type3 = scanner.nextInt();
        } else {
            System.out.println("输入有误，请重新输入");
            scanner.next();
        }
        if (type3 == 1) {
            System.out.println("请输入您要删除的学生学号：");
            if (scanner.hasNextLong()) {
                id = scanner.nextLong();
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
            if (undergraduateDao.queryById(id) != null) {
                System.out.println(OutPutStuInfo.getHeaderByUnGraduate());
                System.out.println(OutPutStuInfo.getRowByUnGraduate(undergraduateDao.queryById(id)));
                undergraduateDao.delete(id);
            }
        } else if (type3 == 2) {
            System.out.println("请输入您要删除的学生学号：");
            if (scanner.hasNextLong()) {
                id = scanner.nextLong();
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
            if (graduateDao.queryById(id) != null) {
                System.out.println(OutPutStuInfo.getHeaderByGraduate());
                System.out.println(OutPutStuInfo.getRowByGraduate(graduateDao.queryById(id)));
                graduateDao.delete(id);
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
        System.out.println("按任意键继续");
        scanner.nextLine();
        scanner.nextLine();
    }

    // 浏览学生
    public static void browseStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        int type4 = 0;
        System.out.println("请选择您要浏览的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        if (scanner.hasNextInt()) {
            type4 = scanner.nextInt();
        } else {
            System.out.println("输入有误，请重新输入");
            scanner.next();
        }
        if (type4 == 1) {
            ArrayList<UnderGraduate> us = undergraduateDao.queryAll();
            System.out.println(OutPutStuInfo.getHeaderByUnGraduate());
            for (UnderGraduate u : us) {
                System.out.println(OutPutStuInfo.getRowByUnGraduate(u));
            }
        } else if (type4 == 2) {
            ArrayList<Graduate> gs = graduateDao.queryAll();
            System.out.println(OutPutStuInfo.getHeaderByGraduate());
            for (Graduate g : gs) {
                System.out.println(OutPutStuInfo.getRowByGraduate(g));
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
        System.out.println("按任意键返回主菜单");
        scanner.nextLine();
        scanner.nextLine();
    }

    // 查询学生
    public static void queryStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        int type5 = 0;
        int type6 = 0;
        System.out.println("请选择您要查询的学生类型：");
        System.out.println("1. 研究生" + "\t" + "2. 本科生");
        if (scanner.hasNextInt()) {
            type5 = scanner.nextInt();
        } else {
            System.out.println("输入有误，请重新输入");
            scanner.next();
        }
        if (type5 == 1) {
            System.out.println("请选择您要查询的方式：");
            System.out.println("1. 按姓名查询" + "\t" + "2. 按学号查询" + "\t" + "3. 按班级查询");
            if (scanner.hasNextInt()) {
                type6 = scanner.nextInt();
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
            scanner.nextLine(); // consume end-of-line character
            if (type6 == 1) {
                System.out.print("请输入学生姓名：");
                name = scanner.nextLine();
                if (graduateDao.queryByName(name) == null) {
                    System.out.println("请按任意键返回主菜单");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                }
                System.out.println(OutPutStuInfo.getHeaderByGraduate());
                System.out.println(OutPutStuInfo.getRowByGraduate(graduateDao.queryByName(name)));
            } else if (type6 == 2) {
                System.out.print("请输入学生学号：");
                if (scanner.hasNextLong()) {
                    id = scanner.nextLong();
                } else {
                    System.out.println("输入有误，请重新输入");
                    scanner.next();
                }
                if (graduateDao.queryById(id) == null) {
                    System.out.println("请按任意键返回主菜单");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                }
                System.out.println(OutPutStuInfo.getHeaderByGraduate());
                System.out.println(OutPutStuInfo.getRowByGraduate(graduateDao.queryById(id)));
            } else if (type6 == 3) {
                System.out.print("请输入学生班级：");
                className = scanner.nextLine();
                if (graduateDao.queryByClass(className) == null) {
                    System.out.println("请按任意键返回主菜单");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                }
                System.out.println(OutPutStuInfo.getHeaderByGraduate());
                ArrayList<Graduate> gs = graduateDao.queryByClass(className);
                for (Graduate g : gs) {
                    System.out.println(OutPutStuInfo.getRowByGraduate(g));
                }
            } else {
                System.out.println("输入有误，请重新输入");
            }
        } else if (type5 == 2) {
            System.out.println("请选择您要查询的方式：");
            System.out.println("1. 按姓名查询" + "\t" + "2. 按学号查询" + "\t" + "3. 按班级查询");
            if (scanner.hasNextInt()) {
                type6 = scanner.nextInt();
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
            scanner.nextLine(); // consume end-of-line character
            if (type6 == 1) {
                System.out.print("请输入学生姓名：");
                name = scanner.nextLine();
                if (undergraduateDao.queryByName(name) == null) {
                    System.out.println("请按任意键返回主菜单");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                }
                System.out.println(OutPutStuInfo.getHeaderByUnGraduate());
                System.out.println(OutPutStuInfo.getRowByUnGraduate(undergraduateDao.queryByName(name)));
            } else if (type6 == 2) {
                System.out.print("请输入学生学号：");
                if (scanner.hasNextLong()) {
                    id = scanner.nextLong();
                } else {
                    System.out.println("输入有误，请重新输入");
                    scanner.next();
                }
                if (undergraduateDao.queryById(id) == null) {
                    System.out.println("请按任意键返回主菜单");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                }
                System.out.println(OutPutStuInfo.getHeaderByUnGraduate());
                System.out.println(OutPutStuInfo.getRowByUnGraduate(undergraduateDao.queryById(id)));
            } else if (type6 == 3) {
                System.out.print("请输入学生班级：");
                className = scanner.nextLine();
                if (undergraduateDao.queryByClass(className) == null) {
                    System.out.println("请按任意键返回主菜单");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                }
                System.out.println(OutPutStuInfo.getHeaderByUnGraduate());
                ArrayList<UnderGraduate> us = undergraduateDao.queryByClass(className);
                for (UnderGraduate u : us) {
                    System.out.println(OutPutStuInfo.getRowByUnGraduate(u));
                }
            } else {
                System.out.println("输入有误，请重新输入");
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
        System.out.println("按任意键返回主菜单");
        scanner.nextLine();
        scanner.nextLine();
    }

    // 排序学生
    public static void sortStu(UndergraduateDao undergraduateDao, GraduateDao graduateDao) {
        Cls.cls();
        int type7 = 0;
        int type8 = 0;
        System.out.println("请选择您要排序的学生类型：");
        System.out.println("1. 本科生" + "\t" + "2. 研究生");
        if (scanner.hasNextInt()) {
            type7 = scanner.nextInt();
        } else {
            System.out.println("输入有误，请重新输入");
            scanner.next();
        }
        if (type7 == 1) {
            System.out.println("请选择您要排序的方式：");
            System.out.println("1. 按姓名排序" + "\t" + "2. 按学号排序" + "\t" + "3. 按语文成绩排序" + "\t" + "4. 按数学成绩排序" + "\t" + "5. 按英语成绩排序" + "\t" + "6. 按总成绩排序");
            if (scanner.hasNextInt()) {
                type8 = scanner.nextInt();
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
            scanner.nextLine(); // consume end-of-line character
            if (type8 == 1) {
                undergraduateDao.sortByName();
            } else if (type8 == 2) {
                undergraduateDao.sortByStudentNum();
            } else if (type8 == 3) {
                undergraduateDao.sortBySubject("Chinese");
            } else if (type8 == 4) {
                undergraduateDao.sortBySubject("Math");
            } else if (type8 == 5) {
                undergraduateDao.sortBySubject("English");
            } else if (type8 == 6) {
                undergraduateDao.sortByTotalScore();
            } else {
                System.out.println("输入有误，请重新输入");
            }
        } else if (type7 == 2) {
            System.out.println("请选择您要排序的方式：");
            System.out.println("1. 按姓名排序" + "\t" + "2. 按学号排序" + "\t" + "3. 按数学成绩排序" + "\t" + "4. 按英语成绩排序" + "\t" + "5. 按历史成绩排序" + "\t" + "6. 按总成绩排序");
            if (scanner.hasNextInt()) {
                type8 = scanner.nextInt();
            } else {
                System.out.println("输入有误，请重新输入");
                scanner.next();
            }
            if (type8 == 1) {
                graduateDao.sortByName();
            } else if (type8 == 2) {
                graduateDao.sortByStudentNum();
            } else if (type8 == 3) {
                graduateDao.sortBySubject("Math");
            } else if (type8 == 4) {
                graduateDao.sortBySubject("English");
            } else if (type8 == 5) {
                graduateDao.sortBySubject("History");
            } else if (type8 == 6) {
                graduateDao.sortByTotalScore();
            } else {
                System.out.println("输入有误，请重新输入");
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
        System.out.println("按任意键返回主菜单");
        scanner.nextLine();
        scanner.nextLine();
    }
}
