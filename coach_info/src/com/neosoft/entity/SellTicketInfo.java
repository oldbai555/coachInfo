package com.neosoft.entity;

//购票表
public class SellTicketInfo {
    int id;
    int ticketInfoId;
    //    CarTicketInfo ticketInfo;
    String peopleName;
    String peopleIdCard;

    public SellTicketInfo(int id, int ticketInfoId, String peopleName, String peopleIdCard) {
        this.id = id;
        this.ticketInfoId = ticketInfoId;
        this.peopleName = peopleName;
        this.peopleIdCard = peopleIdCard;
    }

    public SellTicketInfo(int ticketInfoId, String peopleName, String peopleIdCard) {
        this.ticketInfoId = ticketInfoId;
        this.peopleName = peopleName;
        this.peopleIdCard = peopleIdCard;
    }

    public SellTicketInfo() {
    }

    @Override
    public String toString() {
        return "SellTicketInfo{" +
                "id=" + id +
                ", ticketInfoId=" + ticketInfoId +
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

    public int getTicketInfoId() {
        return ticketInfoId;
    }

    public void setTicketInfoId(int ticketInfoId) {
        this.ticketInfoId = ticketInfoId;
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
