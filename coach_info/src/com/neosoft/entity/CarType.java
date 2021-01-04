package com.neosoft.entity;

//车种表
public class CarType {
    int id;
    String carName;
    int peopleNum;
    String licensePlate;

    public CarType(int id, String carName, int peopleNum, String licensePlate) {
        this.id = id;
        this.carName = carName;
        this.peopleNum = peopleNum;
        this.licensePlate = licensePlate;
    }

    public CarType(String carName, int peopleNum, String licensePlate) {
        this.carName = carName;
        this.peopleNum = peopleNum;
        this.licensePlate = licensePlate;
    }

    public CarType() {
    }

    @Override
    public String toString() {
        return "CarType{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", peopleNum=" + peopleNum +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
