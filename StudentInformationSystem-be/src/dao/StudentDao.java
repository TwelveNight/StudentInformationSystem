package dao;

import model.Student;

/**
 * 学生数据访问对象抽象类，用于对学生进行增删改查等操作
 */
public abstract class StudentDao {

    /**
     * 根据学号删除学生
     *
     * @param StuId 学号
     */
    public abstract void delete(long StuId);


    /**
     * 根据姓名查询学生
     *
     * @param name 姓名
     */
    public Student queryByName(String name) {
        return null;
    }

    /**
     * 按学号排序
     */
    public abstract void sortByStudentNum();


    /**
     * 按姓名排序
     */
    public abstract void sortByName();


    /**
     * 按各科成绩排序
     *
     * @param subjectName 科目名称
     */
    public abstract void sortBySubject(String subjectName);

    /**
     * 按总成绩排序
     */
    public abstract void sortByTotalScore();

    /**
     * 获取学生人数
     *
     * @return 学生人数
     */
    public abstract int getSize();
}

