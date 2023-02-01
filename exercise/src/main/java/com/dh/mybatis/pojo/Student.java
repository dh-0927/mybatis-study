package com.dh.mybatis.pojo;

public class Student {
    private Integer id;
    private String name;
    private Integer currentAge;
    private String address;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentAge=" + currentAge +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(Integer currentAge) {
        this.currentAge = currentAge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
    }

    public Student(Integer id, String name, Integer currentAge, String address) {
        this.id = id;
        this.name = name;
        this.currentAge = currentAge;
        this.address = address;
    }
}
