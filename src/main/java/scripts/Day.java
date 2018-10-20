package scripts;

import java.util.ArrayList;

public class Day
{
    private String day;
    private ArrayList<String> periods;

    private String p1;
    private String p2;
    private String p3;
    private String p4;
    private String p5;

    public Day(ArrayList<String> student)
    {
        this.periods = student;
        this.p1 = student.get(0);
        this.p2 = student.get(1);
        this.p3 = student.get(2);
        this.p4 = student.get(3);
        this.p5 = student.get(4);
    }

    public Day(String day, String p1, String p2, String p3, String p4, String p5)
    {
        this.day = day;

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
    }

    public ArrayList<String> getPeriods() {
        return periods;
    }

    public void setPeriods(ArrayList<String> periods) {
        this.periods = periods;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }
}

