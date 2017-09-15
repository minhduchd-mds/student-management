package javaconsole.entity;

public class Student {

    private int id;
    private String name;
    private String email;
    private  String rollnumber;
    private String className;
    private int status;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRoll0number(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }     

    public Student(int id, String name, String email, String rollnumber, String className, int status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rollnumber = rollnumber;
        this.className = className;
        this.status = status;
    }

    public Student() {
    }

   
}