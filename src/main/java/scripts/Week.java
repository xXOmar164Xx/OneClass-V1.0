package scripts;

import java.util.ArrayList;

public class Week
{
    private int id;
    private String name;
    private ArrayList<Day> days;

    private Day monday;
    private String mp1;
    private String mp2;
    private String mp3;
    private String mp4;
    private String mp5;

    private Day tuesday;
    private String tp1;
    private String tp2;
    private String tp3;
    private String tp4;
    private String tp5;

    private Day wednesday;
    private String wp1;
    private String wp2;
    private String wp3;
    private String wp4;
    private String wp5;

    private Day thursday;
    private String thp1;
    private String thp2;
    private String thp3;
    private String thp4;
    private String thp5;

    private Day friday;
    private String fp1;
    private String fp2;
    private String fp3;
    private String fp4;
    private String fp5;

    public Week(String name, int id, ArrayList<Day> days)
    {
        this.name = name;
        this.id = id;
        this.days = days;

        this.monday = days.get(0);
        this.monday.setDay("Mon");
        this.mp1 = monday.getP1();
        this.mp2 = monday.getP2();
        this.mp3 = monday.getP3();
        this.mp4 = monday.getP4();
        this.mp5 = monday.getP5();

        this.tuesday = days.get(1);
        this.tuesday.setDay("Tue");
        this.tp1 = tuesday.getP1();
        this.tp2 = tuesday.getP2();
        this.tp3 = tuesday.getP3();
        this.tp4 = tuesday.getP4();
        this.tp5 = tuesday.getP5();

        this.wednesday = days.get(2);
        this.wednesday.setDay("Wed");
        this.wp1 = wednesday.getP1();
        this.wp2 = wednesday.getP2();
        this.wp3 = wednesday.getP3();
        this.wp4 = wednesday.getP4();
        this.wp5 = wednesday.getP5();

        this.thursday = days.get(3);
        this.thursday.setDay("Thu");
        this.thp1 = thursday.getP1();
        this.thp2 = thursday.getP2();
        this.thp3 = thursday.getP3();
        this.thp4 = thursday.getP4();
        this.thp5 = thursday.getP5();

        this.friday = days.get(4);
        this.friday.setDay("Fri");
        this.fp1 = friday.getP1();
        this.fp2 = friday.getP2();
        this.fp3 = friday.getP3();
        this.fp4 = friday.getP4();
        this.fp5 = friday.getP5();
    }

    public void setPeriod(int pos, String newValue) {
        switch (pos) {
            case 1:
                this.mp1 = newValue;
                break;
            case 2:
                this.mp2 = newValue;
                break;
            case 3:
                this.mp3 = newValue;
                break;
            case 4:
                this.mp4 = newValue;
                break;
            case 5:
                this.mp5 = newValue;
                break;
            case 6:
                this.tp1 = newValue;
                break;
            case 7:
                this.tp2 = newValue;
                break;
            case 8:
                this.tp3 = newValue;
                break;
            case 9:
                this.tp4 = newValue;
                break;
            case 10:
                this.tp5 = newValue;
                break;
            case 11:
                this.wp1 = newValue;
                break;
            case 12:
                this.wp2 = newValue;
                break;
            case 13:
                this.wp3 = newValue;
                break;
            case 14:
                this.wp4 = newValue;
                break;
            case 15:
                this.wp5 = newValue;
                break;
            case 16:
                this.thp1 = newValue;
                break;
            case 17:
                this.thp2 = newValue;
                break;
            case 18:
                this.thp3 = newValue;
                break;
            case 19:
                this.thp4 = newValue;
                break;
            case 20:
                this.thp5 = newValue;
                break;
            case 21:
                this.fp1 = newValue;
                break;
            case 22:
                this.fp2 = newValue;
                break;
            case 23:
                this.fp3 = newValue;
                break;
            case 24:
                this.fp4 = newValue;
                break;
            case 25:
                this.fp5 = newValue;
                break;
        }

        refreshDays();
    }

    private void refreshDays()
    {
        this.monday = new Day("Mon", mp1, mp2, mp3, mp4, mp5);
        this.tuesday = new Day("Tue", tp1, tp2, tp3, tp4, tp5);
        this.wednesday = new Day("Wed",wp1, wp2, wp3, wp4, wp5);
        this.thursday = new Day("Thu", thp1, thp2, thp3, thp4, thp5);
        this.friday = new Day("Fri", fp1, fp2, fp3, fp4, fp5);
    }

    public ArrayList<Day> getDays()
    {
        ArrayList<Day> days = new ArrayList<>();
        days.add(monday);
        days.add(tuesday);
        days.add(wednesday);
        days.add(thursday);
        days.add(friday);

        return days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMp1() {
        return mp1;
    }

    public void setMp1(String mp1) {
        this.mp1 = mp1;
    }

    public String getMp2() {
        return mp2;
    }

    public void setMp2(String mp2) {
        this.mp2 = mp2;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public String getMp5() {
        return mp5;
    }

    public void setMp5(String mp5) {
        this.mp5 = mp5;
    }

    public String getTp1() {
        return tp1;
    }

    public void setTp1(String tp1) {
        this.tp1 = tp1;
    }

    public String getTp2() {
        return tp2;
    }

    public void setTp2(String tp2) {
        this.tp2 = tp2;
    }

    public String getTp3() {
        return tp3;
    }

    public void setTp3(String tp3) {
        this.tp3 = tp3;
    }

    public String getTp4() {
        return tp4;
    }

    public void setTp4(String tp4) {
        this.tp4 = tp4;
    }

    public String getTp5() {
        return tp5;
    }

    public void setTp5(String tp5) {
        this.tp5 = tp5;
    }

    public String getWp1() {
        return wp1;
    }

    public void setWp1(String wp1) {
        this.wp1 = wp1;
    }

    public String getWp2() {
        return wp2;
    }

    public void setWp2(String wp2) {
        this.wp2 = wp2;
    }

    public String getWp3() {
        return wp3;
    }

    public void setWp3(String wp3) {
        this.wp3 = wp3;
    }

    public String getWp4() {
        return wp4;
    }

    public void setWp4(String wp4) {
        this.wp4 = wp4;
    }

    public String getWp5() {
        return wp5;
    }

    public void setWp5(String wp5) {
        this.wp5 = wp5;
    }

    public String getThp1() {
        return thp1;
    }

    public void setThp1(String thp1) {
        this.thp1 = thp1;
    }

    public String getThp2() {
        return thp2;
    }

    public void setThp2(String thp2) {
        this.thp2 = thp2;
    }

    public String getThp3() {
        return thp3;
    }

    public void setThp3(String thp3) {
        this.thp3 = thp3;
    }

    public String getThp4() {
        return thp4;
    }

    public void setThp4(String thp4) {
        this.thp4 = thp4;
    }

    public String getThp5() {
        return thp5;
    }

    public void setThp5(String thp5) {
        this.thp5 = thp5;
    }

    public String getFp1() {
        return fp1;
    }

    public void setFp1(String fp1) {
        this.fp1 = fp1;
    }

    public String getFp2() {
        return fp2;
    }

    public void setFp2(String fp2) {
        this.fp2 = fp2;
    }

    public String getFp3() {
        return fp3;
    }

    public void setFp3(String fp3) {
        this.fp3 = fp3;
    }

    public String getFp4() {
        return fp4;
    }

    public void setFp4(String fp4) {
        this.fp4 = fp4;
    }

    public String getFp5() {
        return fp5;
    }

    public void setFp5(String fp5) {
        this.fp5 = fp5;
    }
}
