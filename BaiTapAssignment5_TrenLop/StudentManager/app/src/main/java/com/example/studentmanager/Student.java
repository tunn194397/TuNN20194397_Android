package com.example.studentmanager;

public class Student {
    String id;
    String name;
    String email;
    String address;
    String phone;
    String birthday;

    public Student(String studentId, String name, String email, String address, String phone, String birthday) {
        super();
        this.id = studentId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
    }

    public Student(String studentId, String name) {
        this.id = studentId;
        this.name = name;
    }

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
