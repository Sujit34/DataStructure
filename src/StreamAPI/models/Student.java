package StreamAPI.models;

import java.util.List;
public class Student{
    public int id;
    public String name;
    public String email;
    public List<String> phoneNumber;

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double grade;
    public Student(int id, String name, String email, double grade,List<String> phoneNumber){
        this.id = id;
        this.name = name;
        this.email =email;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<String> getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}