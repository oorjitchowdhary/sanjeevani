package com.oorjitchowdhary.sanjeevani.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Doner implements Parcelable {

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

    protected Doner(Parcel in) {
        name = in.readString();
        age = in.readString();
        address = in.readString();
        bloodgroup = in.readString();
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

    @Override
    public String toString() {
        return "Doner{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
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
    }
}
