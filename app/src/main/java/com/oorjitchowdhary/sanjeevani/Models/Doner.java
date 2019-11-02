package com.oorjitchowdhary.sanjeevani.Models;

public class Doner {

    private String name;
    private String age;
    private String address;
    private String bloodgroup;

    public Doner(String name, String age, String address, String bloodgroup) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.bloodgroup = bloodgroup;
    }

    public Doner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    @Override
    public String toString() {
        return "Doner{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                '}';
    }
}
