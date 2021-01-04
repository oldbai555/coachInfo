package com.neosoft.entity;

//车票表
public class CarTicketTab {
    int id;
//    int ticketInfoId;

    CarTicketInfo ticketInfo;
    int ticketNum;
    int ticketSum;

    public CarTicketTab(int id, CarTicketInfo ticketInfo, int ticketNum, int ticketSum) {
        this.id = id;
        this.ticketInfo = ticketInfo;
        this.ticketNum = ticketNum;
        this.ticketSum = ticketSum;
    }

    public CarTicketTab(CarTicketInfo ticketInfo, int ticketNum, int ticketSum) {
        this.ticketInfo = ticketInfo;
        this.ticketNum = ticketNum;
        this.ticketSum = ticketSum;
    }

    public CarTicketTab() {
    }

    @Override
    public String toString() {
        return "CarTicketTab{" +
                "id=" + id +
                ", ticketInfo=" + ticketInfo +
                ", ticketNum=" + ticketNum +
                ", ticketSum=" + ticketSum +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarTicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(CarTicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getTicketSum() {
        return ticketSum;
    }

    public void setTicketSum(int ticketSum) {
        this.ticketSum = ticketSum;
    }
}
