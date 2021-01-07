package com.neosoft.entity;

/**
 * 汽车行驶时间
 */
public class Series4 {
    private String  name;
    private double num;

    @Override
    public String toString() {
        return "Series4{" +
                "name=" + name +
                ", num=" + num +
                '}';
    }

    public Series4(String name, double num) {
        this.name = name;
        this.num = num;
    }
}
