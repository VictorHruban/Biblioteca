package com.company;

public class Genuri {
    private String denumire;
    private  int id;


    public Genuri(){

    }
    public Genuri(int id) {
        this.id=id;
    }

    public Genuri(String denumire, int id) {
        this.denumire=denumire;
        this.id=id;

    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Genuri{" +
                "denumire='" + denumire + '\'' +
                ", id=" + id +
                '}';
    }
}
