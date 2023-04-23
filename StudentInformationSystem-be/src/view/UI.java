package view;

import util.Cls;

public class UI {
    public static void menu() {
        Cls.cls();
        System.out.println("请选择您要进行的操作：");
        System.out.println("1. 增加学生信息");
        System.out.println("2. 修改学生信息");
        System.out.println("3. 删除学生信息");
        System.out.println("4. 浏览学生信息");
        System.out.println("5. 查询学生信息");
        System.out.println("6. 排序显示学生信息");
        System.out.println("7. 查看本科生人数");
        System.out.println("8. 查看研究生人数");
        System.out.println("9. 查看所有学生人数");
        System.out.println("0. 退出系统");
    }
}
