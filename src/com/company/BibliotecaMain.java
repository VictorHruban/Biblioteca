package com.company;

import java.util.List;

public class BibliotecaMain {
    public static void main(String[] args) {
        /*AuthorDB authorDB = new AuthorDB();
        Author author = authorDB.findById(3);

        System.out.println(author);



        Author author1 = new Author();
        author1.setName("Mihai");
        author1.setSurname("Preda");
        authorDB.save(author1);



        CarteDao carteDao= new CarteDao();
        Books books= carteDao.findById(4);
        System.out.println(books);

        List<Books> booksList=carteDao.findAll();
        System.out.println(booksList);


        Books books1= new Books();
        books1.setDenumire("KLasd");
        books1.setEditura("Leda");
        books1.setAuthor(new Author(1));
        books1.setGenuri(new Genuri(1));
        books1.setId(1);
        carteDao.save(books1); */

        ClientiDao clientiDao = new ClientiDao();
        Client clienti = clientiDao.findById(2);
        System.out.println(clienti);

        Client client1 = new Client();
        client1.setName("Avram");
        client1.setSurname("Alina");
        client1.setPhone(07515264);
        client1.setEmail("avramalina@yahoo.com");
        client1.setAddress("Strada Alexandru Cuza, nr. 42");
        clientiDao.save(client1);




    }
}
