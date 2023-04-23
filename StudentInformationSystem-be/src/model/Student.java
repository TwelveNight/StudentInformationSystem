package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id; // 学号
    private String name; // 姓名
    private int age; // 年龄
    private Address address; // 地址

    private String classNum; // 班级

    protected List<Score> scores; // 成绩


    public Student(int id, String name, int age, Address address, String classNum) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classNum = classNum;
        this.scores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return String.valueOf(age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public String getAddressString() {
        return address.toString();
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public List<Score> getScores() {
        return scores;
    }

    public String printScores() {
        StringBuilder sb = new StringBuilder();
        for (Score score : scores) {
            sb.append(score.getGrade()).append("  ");
        }
        return sb.toString();
    }

    public double getScore(String courseName) {
        for (Score score : scores) {
            if (score.getCourseName().equals(courseName)) {
                return score.getGrade();
            }
        }
        return 0.0f;
    }


    public float getTotalScore() {
        float totalScore = 0.0f;
        for (Score score : scores) {
            totalScore += score.getGrade();
        }
        return totalScore;
    }
}
