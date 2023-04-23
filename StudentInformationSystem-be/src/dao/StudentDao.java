//package dao;
//
//import model.Student;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//
///**
// * 学生数据访问对象抽象类，用于对学生进行增删改查等操作
// */
//public abstract class StudentDao {
//    protected static ArrayList<Student> studentList; // 学生列表
//
//    /**
//     * 新增学生
//     *
//     * @param student 学生对象
//     * @return 新增成功返回 true，否则返回 false
//     */
//    public boolean add(Student student) {
//        // 判断学号是否已存在
//        for (Student s : studentList) {
//            if (s.getId().equals(student.getId())) {
//                System.out.println("学号已存在");
//                return false;
//            }
//        }
//        studentList.add(student);
//        System.out.println("添加成功");
//        return true;
//    }
//
//    /**
//     * 根据学号删除学生
//     *
//     * @param StuId 学号
//     */
//    public void delete(String StuId) {
//        for (Student s : studentList) {
//            if (s.getId().equals(StuId)) {
//                studentList.remove(s);
//                System.out.println("删除成功");
//                return;
//            }
//        }
//        System.out.println("学号不存在");
//    }
//
//    /**
//     * 根据学号查询学生
//     *
//     * @param stuId 学号
//     */
//    public Student queryById(String stuId) {
//        for (Student s : studentList) {
//            if (s.getId().equals(stuId)) {
//                return s;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 根据姓名查询学生
//     *
//     * @param name 姓名
//     */
//    public Student queryByName(String name) {
//        for (Student s : studentList) {
//            if (s.getName().equals(name)) {
//                return s;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 根据班级查询学生
//     *
//     * @param classNum 班级号
//     */
//    public ArrayList<Student> queryByClass(String classNum) {
//        ArrayList<Student> students = new ArrayList<>();
//        for (Student s : studentList) {
//            if (s.getClassNum().equals(classNum)) {
//                students.add(s);
//            }
//        }
//        return students;
//    }
//
//    /**
//     * 查询所有学生
//     *
//     * @return 学生列表
//     */
//    public ArrayList<Student> queryAll() {
//        return studentList;
//    }
//
//    /**
//     * 按学号排序
//     */
//    public void sortByStudentNum() {
//        studentList.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.getId().compareTo(s2.getId());
//            }
//        });
//    }
//
//    ;
//
//    /**
//     * 按姓名排序
//     */
//    public void sortByName() {
//        studentList.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.getName().compareTo(s2.getName());
//            }
//        });
//    }
//
//
//    /**
//     * 按各科成绩排序
//     *
//     * @param students    学生数组
//     * @param subjectName 科目名称
//     */
//    public static void sortBySubject(Student[] students, String subjectName) {
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                float s1Score = s1.getScore(subjectName);
//                float s2Score = s2.getScore(subjectName);
//                return Float.compare(s2Score, s1Score);
//            }
//        });
//    }
//
//    /**
//     * 按总成绩排序
//     *
//     * @param students 学生数组
//     */
//    public static void sortByTotalScore(Student[] students) {
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                float s1Score = s1.getTotalScore();
//                float s2Score = s2.getTotalScore();
//                return Float.compare(s2Score, s1Score);
//            }
//        });
//    }
//
//    /**
//     * 获取学生人数
//     *
//     * @return 学生人数
//     */
//    public int getSize() {
//        return studentList.size();
//    }
//
//}
//
