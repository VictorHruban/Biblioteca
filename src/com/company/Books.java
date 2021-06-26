package com.company;

import java.util.Date;

public class Books {
    private String denumire;
    private Author author;
    private Genuri genuri;
    private String editura;
    private Date   an_aparitie;
    private int id;
    public Books(){

    }
    public Books(String denumire,Author author, Genuri genuri, String editura, Date an_aparitie,int id){
        this.denumire=denumire;
        this.author=author;
        this.genuri=genuri;
        this.editura=editura;
        this.an_aparitie=an_aparitie;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genuri getGenuri() {
        return genuri;
    }

    public void setGenuri(Genuri genuri) {
        this.genuri = genuri;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public Date getAn_aparitie() {
        return an_aparitie;
    }

    public void setAn_aparitie(Date an_aparitie) {
        this.an_aparitie = an_aparitie;
    }

    @Override
    public String toString() {
        return "Books{" +
                "denumire='" + denumire + '\'' +
                ", author=" + author +
                ", genuri=" + genuri +
                ", editura='" + editura + '\'' +
                ", an_aparitie=" + an_aparitie +
                ", id=" + id +
                '}';
    }
}
