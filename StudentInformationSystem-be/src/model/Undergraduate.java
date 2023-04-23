package model;

public class Undergraduate extends Student {

    private String grade; // 年级
    private String major; // 专业

    public Undergraduate(int id, String name, int age, Address address, String classNum, String grade, String major, double mathScore, double englishScore, double historyScore) {
        super(id, name, age, address, classNum);
        scores.add(new Score("Chinese", mathScore));
        scores.add(new Score("Math", englishScore));
        scores.add(new Score("English", historyScore));
        this.grade = grade;
        this.major = major;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
