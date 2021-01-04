package com.neosoft.entity;
//车票信息表
public class CarTicketInfo {
    int id;
//    CarType carType;
    CarInfo carInfo;
    String ticketName;

    public CarTicketInfo(int id, CarInfo carInfo, String ticketName) {
        this.id = id;
        this.carInfo = carInfo;
        this.ticketName = ticketName;
    }

    public CarTicketInfo(CarInfo carInfo, String ticketName) {
        this.carInfo = carInfo;
        this.ticketName = ticketName;
    }

    public CarTicketInfo() {
    }

    @Override
    public String toString() {
        return "CarTicketInfo{" +
                "id=" + id +
                ", carInfo=" + carInfo +
                ", ticketName='" + ticketName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }
}
