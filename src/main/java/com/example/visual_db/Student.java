package main.java.com.example.visual_db;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String profession;
    private int age;
    private boolean isBudget;
    private boolean hasDebts;

    public Student(int id, String surname, String name, String profession, int age) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.profession = profession;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", age=" + age +
                '}';
    }
}
