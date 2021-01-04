package com.neosoft.entity;

//车票表
public class CarTicketTab {
    int id;
    int ticketInfoId;
//    CarTicketInfo ticketInfo;
    int ticketNum;
    int ticketSum;

    public CarTicketTab(int id, int ticketInfoId, int ticketNum, int ticketSum) {
        this.id = id;
        this.ticketInfoId = ticketInfoId;
        this.ticketNum = ticketNum;
        this.ticketSum = ticketSum;
    }

    public CarTicketTab(int ticketInfoId, int ticketNum, int ticketSum) {
        this.ticketInfoId = ticketInfoId;
        this.ticketNum = ticketNum;
        this.ticketSum = ticketSum;
    }

    public CarTicketTab() {
    }

    @Override
    public String toString() {
        return "CarTicketTab{" +
                "id=" + id +
                ", ticketInfoId=" + ticketInfoId +
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

    public int getTicketInfoId() {
        return ticketInfoId;
    }

    public void setTicketInfoId(int ticketInfoId) {
        this.ticketInfoId = ticketInfoId;
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
