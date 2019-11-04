package com.oorjitchowdhary.sanjeevani.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Doner implements Parcelable {

    private String name, age, address, bloodgroup, gender, message;

    public Doner(String name, String age, String address, String bloodgroup, String gender) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.bloodgroup = bloodgroup;
        this.gender = gender;
        this.message = message;
    }

    public Doner() {
    }

    protected Doner(Parcel in) {
        name = in.readString();
        age = in.readString();
        address = in.readString();
        bloodgroup = in.readString();
        gender = in.readString();
        message = in.readString();
    }

    public static final Creator<Doner> CREATOR = new Creator<Doner>() {
        @Override
        public Doner createFromParcel(Parcel in) {
            return new Doner(in);
        }

        @Override
        public Doner[] newArray(int size) {
            return new Doner[size];
        }
    };

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

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "Doner{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                ", gender='" + gender + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(age);
        parcel.writeString(address);
        parcel.writeString(bloodgroup);
        parcel.writeString(gender);
        parcel.writeString(message);
    }
}
