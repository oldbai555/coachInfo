package com.neosoft.entity;
//发车信息表
public class CarInfo {
    int id;
//    int carId;
    CarType carType;
    String routeStart;
    String routeEnd;
    String car_start_time;
    double probably_time;

    public CarInfo(int id, CarType carType, String routeStart, String routeEnd, String car_start_time, double probably_time) {
        this.id = id;
        this.carType = carType;
        this.routeStart = routeStart;
        this.routeEnd = routeEnd;
        this.car_start_time = car_start_time;
        this.probably_time = probably_time;
    }

    public CarInfo(CarType carType, String routeStart, String routeEnd, String car_start_time, double probably_time) {
        this.carType = carType;
        this.routeStart = routeStart;
        this.routeEnd = routeEnd;
        this.car_start_time = car_start_time;
        this.probably_time = probably_time;
    }

    public CarInfo() {
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "id=" + id +
                ", carType=" + carType +
                ", routeStart='" + routeStart + '\'' +
                ", routeEnd='" + routeEnd + '\'' +
                ", car_start_time='" + car_start_time + '\'' +
                ", probably_time=" + probably_time +
                '}';
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

    public String getRouteStart() {
        return routeStart;
    }

    public void setRouteStart(String routeStart) {
        this.routeStart = routeStart;
    }

    public String getRouteEnd() {
        return routeEnd;
    }

    public void setRouteEnd(String routeEnd) {
        this.routeEnd = routeEnd;
    }

    public String getCar_start_time() {
        return car_start_time;
    }

    public void setCar_start_time(String car_start_time) {
        this.car_start_time = car_start_time;
    }

    public double getProbably_time() {
        return probably_time;
    }

    public void setProbably_time(double probably_time) {
        this.probably_time = probably_time;
    }
}
