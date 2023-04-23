package model;

/**
 * 成绩类，包括课程名和成绩两个属性
 */
public class Score {
    private String courseName;  // 课程名
    private double grade;  // 成绩

    /**
     * 构造函数
     *
     * @param courseName 课程名
     * @param grade      成绩
     */
    public Score(String courseName, double grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    // 各属性的get、set方法
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
