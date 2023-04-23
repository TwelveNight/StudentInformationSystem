package dao;

import model.Graduate;
import model.Student;

import java.util.ArrayList;
import java.util.Comparator;


public class GraduateDao extends StudentDao {

    protected static ArrayList<Graduate> studentList = new ArrayList<>(); // 学生列表


    /**
     * 新增学生
     *
     * @param student 学生对象
     * @return 新增成功返回 true，否则返回 false
     */
    public boolean add(Graduate student) {
        // 判断学号是否已存在
        for (Graduate s : studentList) {
            if (s.getId() == student.getId()) {
                System.out.println("学号已存在");
                return false;
            }
        }
        studentList.add(student);
        System.out.println("添加成功");
        return true;
    }

    /**
     * 根据学号删除学生
     *
     * @param StuId 学号
     */
    public void delete(long StuId) {
        for (Graduate s : studentList) {
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
    public Graduate queryById(long stuId) {
        for (Graduate s : studentList) {
            if (s.getId() == stuId) {
                return s;
            }
        }
        System.out.println("学号不存在");
        return null;
    }

    /**
     * 修改学生信息
     *
     * @param student 学生对象
     */
    public void modify(long stuId, Graduate student) {
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
     * 根据姓名查询学生
     *
     * @param name 姓名
     */
    public Graduate queryByName(String name) {
        for (Graduate s : studentList) {
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
    public ArrayList<Graduate> queryByClass(String classNum) {
        ArrayList<Graduate> students = new ArrayList<>();
        for (Graduate s : studentList) {
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
     * 查询所有学生
     *
     * @return 学生列表
     */
    public ArrayList<Graduate> queryAll() {
        return studentList;
    }

    /**
     * 按学号排序
     */
    public void sortByStudentNum() {
        if (studentList.size() == 0) {
            System.out.println("学生列表为空");
            return;
        }
        studentList.sort(Comparator.comparing(Student::getId));
        System.out.println("排序成功");
    }


    /**
     * 按姓名排序
     */
    public void sortByName() {
        if (studentList.size() == 0) {
            System.out.println("学生列表为空");
            return;
        }
        studentList.sort(Comparator.comparing(Student::getName));
        System.out.println("排序成功");
    }


    /**
     * 按各科成绩排序
     *
     * @param subjectName 科目名称
     */
    public void sortBySubject(String subjectName) {
        if (studentList.size() == 0) {
            System.out.println("学生列表为空");
            return;
        }
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
        if (studentList.size() == 0) {
            System.out.println("学生列表为空");
            return;
        }
        studentList.sort((s1, s2) -> {
            float s1Score = s1.getTotalScore();
            float s2Score = s2.getTotalScore();
            return Float.compare(s2Score, s1Score);
        });
        System.out.println("排序成功");
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
