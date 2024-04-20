package Classes;

// Function for learner information
class Learner {
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
    //Constuctor of Learner class
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
        this.cancel= new int[50];
        this.cancelcount=0;
    }
    
}