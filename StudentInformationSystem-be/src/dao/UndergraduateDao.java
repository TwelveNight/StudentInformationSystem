package dao;

import model.Student;
import model.UnderGraduate;

import java.util.ArrayList;
import java.util.Comparator;

public class UndergraduateDao extends StudentDao {
    protected static ArrayList<UnderGraduate> studentList = new ArrayList<>(); // 学生列表

    /**
     * 新增学生
     *
     * @param student 学生对象
     */
    public void add(UnderGraduate student) {
        // 判断学号是否已存在
        for (UnderGraduate s : studentList) {
            if (s.getId() == student.getId()) {
                System.out.println("学号已存在");
                return;
            }
        }
        studentList.add(student);
        System.out.println("添加成功");
    }

    /**
     * 根据学号删除学生
     *
     * @param StuId 学号
     */
    @Override
    public void delete(long StuId) {
        for (UnderGraduate s : studentList) {
            if (s.getId() == StuId) {
                studentList.remove(s);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("学号不存在");
    }

    /**
     * 根据学号查询学生
     *
     * @param stuId 学号
     */
    public UnderGraduate queryById(long stuId) {
        for (UnderGraduate s : studentList) {
            if (s.getId() == stuId) {
                return s;
            }
        }
        System.out.println("学号不存在");
        return null;
    }

    /**
     * 根据姓名查询学生
     *
     * @param name 姓名
     */
    public UnderGraduate queryByName(String name) {
        for (UnderGraduate s : studentList) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        System.out.println("姓名不存在");
        return null;
    }

    /**
     * 根据班级查询学生
     *
     * @param classNum 班级号
     */
    public ArrayList<UnderGraduate> queryByClass(String classNum) {
        ArrayList<UnderGraduate> students = new ArrayList<>();
        for (UnderGraduate s : studentList) {
            if (s.getClassNum().equals(classNum)) {
                students.add(s);
            }
        }
        if (students.size() == 0) {
            System.out.println("班级不存在");
            return null;
        }
        return students;
    }

    /**
     * 根据学号修改学生信息
     *
     * @param stuId 学号
     */
    public void modify(long stuId, UnderGraduate student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == stuId) {
                studentList.set(i, student);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("学号不存在");
    }

    /**
     * 查询所有学生
     *
     * @return 学生列表
     */
    public ArrayList<UnderGraduate> queryAll() {
        return studentList;
    }

    /**
     * 按学号排序
     */
    public void sortByStudentNum() {
        studentList.sort(Comparator.comparing(Student::getId));
        System.out.println("排序成功");
    }


    /**
     * 按姓名排序
     */
    public void sortByName() {
        studentList.sort(Comparator.comparing(Student::getName));
        System.out.println("排序成功");
    }


    /**
     * 按各科成绩排序
     *
     * @param subjectName 科目名称
     */
    public void sortBySubject(String subjectName) {
        studentList.sort((s1, s2) -> {
            float s1Score = (float) s1.getScore(subjectName);
            float s2Score = (float) s2.getScore(subjectName);
            return Float.compare(s2Score, s1Score);
        });
        System.out.println("排序成功");
    }


    /**
     * 按总成绩排序
     */
    public void sortByTotalScore() {
        studentList.sort((s1, s2) -> {
            float s1Score = s1.getTotalScore();
            float s2Score = s2.getTotalScore();
            return Float.compare(s2Score, s1Score);
        });
    }

    /**
     * 获取学生人数
     *
     * @return 学生人数
     */
    public int getSize() {
        return studentList.size();
    }

}
