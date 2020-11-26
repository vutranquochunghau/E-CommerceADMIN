package com.example.e_commerceadmin.Activity;

public class Model {
    @Override
    public String toString() {
        return "Model{" +
                "ten='" + ten + '\'' +
                '}';
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    private String ten;
    public  Model(){}

}
