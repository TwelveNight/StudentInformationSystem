package model;

public class Graduate extends Student {
    private String advisor; // 导师
    private String researchArea; // 研究方向


    public Graduate(long id, String name, int age, Address address, String classNum, String advisor, String researchArea, double mathScore, double englishScore, double historyScore) {
        super(id, name, age, address, classNum);
        scores.add(new Score("Math", mathScore));
        scores.add(new Score("English", englishScore));
        scores.add(new Score("History", historyScore));
        this.advisor = advisor;
        this.researchArea = researchArea;
    }


    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

}
