package Classes;

// Function for learner information
public class Learner {
    private String name;
    private String gender;
    private int age;
    private String phone;
    private int grade;
    private int lesson1;
    private int lesson2;
    private Boolean attended1;
    private Boolean attended2;
    private int[] cancel;
    private int cancelcount;

    // Constuctor of Learner class
    public Learner(String name, String gender, int age, String phone, int grade) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.grade = grade;
        this.lesson1 = 0;
        this.lesson2 = 0;
        this.attended1 = false;
        this.attended2 = false;
        this.cancel = new int[50];
        this.cancelcount = 0;
    }

    // getter and setter for accessing private variables
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public int getGrade() {
        return grade;
    }

    public int getLesson1() {
        return lesson1;
    }

    public int getLesson2() {
        return lesson2;
    }

    public Boolean getAttended1() {
        return attended1;
    }

    public Boolean getAttended2() {
        return attended2;
    }

    public int[] getCancel() {
        return cancel;
    }

    public int getCancelCount() {
        return cancelcount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setLesson1(int lesson1) {
        this.lesson1 = lesson1;
    }

    public void setLesson2(int lesson2) {
        this.lesson2 = lesson2;
    }

    public void setAttended1(Boolean attended1) {
        this.attended1 = attended1;
    }

    public void setAttended2(Boolean attended2) {
        this.attended2 = attended2;
    }

    public void setCancel(int pos, int val) {
        this.cancel[pos] = val;
    }

    public void setCancelCount(int cancelcount) {
        this.cancelcount = cancelcount;
    }
}