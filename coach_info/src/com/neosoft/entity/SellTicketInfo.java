package com.neosoft.entity;

//购票表
public class SellTicketInfo {
    int id;
    CarTicketInfo ticketInfo;
    String peopleName;
    String peopleIdCard;

    public SellTicketInfo(int id, CarTicketInfo ticketInfo, String peopleName, String peopleIdCard) {
        this.id = id;
        this.ticketInfo = ticketInfo;
        this.peopleName = peopleName;
        this.peopleIdCard = peopleIdCard;
    }

    public SellTicketInfo(CarTicketInfo ticketInfo, String peopleName, String peopleIdCard) {
        this.ticketInfo = ticketInfo;
        this.peopleName = peopleName;
        this.peopleIdCard = peopleIdCard;
    }

    public SellTicketInfo() {
    }

    @Override
    public String toString() {
        return "SellTicketInfo{" +
                "id=" + id +
                ", ticketInfo=" + ticketInfo +
                ", peopleName='" + peopleName + '\'' +
                ", peopleIdCard='" + peopleIdCard + '\'' +
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

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleIdCard() {
        return peopleIdCard;
    }

    public void setPeopleIdCard(String peopleIdCard) {
        this.peopleIdCard = peopleIdCard;
    }
}
