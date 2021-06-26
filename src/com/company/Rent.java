package com.company;

public class Rent {
    int id;
    private Books books;
    private Client client;
    private int data_imprumut;
    private int data_retur;


    public Rent() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rent(int id, Books books, Client client, int data_imprumut, int data_retur) {
        this.id=id;
        this.books=books;
        this.client=client;
        this.data_imprumut=data_imprumut;
        this.data_retur=data_retur;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getData_imprumut() {
        return data_imprumut;
    }

    public void setData_imprumut(int data_imprumut) {
        this.data_imprumut = data_imprumut;
    }

    public int getData_retur() {
        return data_retur;
    }

    public void setData_retur(int data_retur) {
        this.data_retur = data_retur;
    }
}
