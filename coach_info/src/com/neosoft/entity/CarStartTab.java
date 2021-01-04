package com.neosoft.entity;

import java.sql.Date;

//发车记录表
public class CarStartTab {
    int id;
    //    int carId;
    CarType carType;
    int actualNum;
    Date startTime;

    @Override
    public String toString() {
        return "CarStartTab{" +
                "id=" + id +
                ", carType=" + carType +
                ", actualNum=" + actualNum +
                ", startTime=" + startTime +
                '}';
    }

    public CarStartTab(int id, CarType carType, int actualNum, Date startTime) {
        this.id = id;
        this.carType = carType;
        this.actualNum = actualNum;
        this.startTime = startTime;
    }

    public CarStartTab(CarType carType, int actualNum, Date startTime) {
        this.carType = carType;
        this.actualNum = actualNum;
        this.startTime = startTime;
    }

    public CarStartTab() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getActualNum() {
        return actualNum;
    }

    public void setActualNum(int actualNum) {
        this.actualNum = actualNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
