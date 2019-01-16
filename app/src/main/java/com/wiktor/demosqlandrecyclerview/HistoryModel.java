package com.wiktor.demosqlandrecyclerview;

public class HistoryModel {
    private String time, shop, notes;
    private int id, number1, number2, number3, prise;

    HistoryModel(int id, String time, int num1, int num2, int num3, String shop, int prise, String notes) {
        this.id = id;
        this.time = time;
        number1 = num1;
        number2 = num2;
        number3 = num3;
        this.shop = shop;
        this.prise = prise;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getShop() {
        return shop;
    }

    public String getNotes() {
        return notes;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }

    public int getPrise() {
        return prise;
    }
}
