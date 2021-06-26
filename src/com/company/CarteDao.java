package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteDao {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String password = "victor";


    public Books findById(int id) {
        Books books = new Books();

        String query = "select c.id,c.denumire,c.editura,c.an_aparitie,a.id,a.nume,a.prenume,g.id,g.denumire " +
                "from carti c\n" +
                "inner join autor a on c.id_autor=a.id\n" +
                "inner join genuri g on c.id_gen=g.id\n" +
                "where c.id=?";


        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                books.setAn_aparitie(resultSet.getDate("c.an_aparitie"));
                books.setId(resultSet.getInt("c.id"));
                books.setDenumire(resultSet.getString("c.denumire"));
                books.setEditura(resultSet.getString("c.denumire"));

                Author author = new Author();
                author.setId(resultSet.getInt("a.id"));
                author.setName(resultSet.getString("a.nume"));
                author.setSurname(resultSet.getString("a.prenume"));
                books.setAuthor(author);


                Genuri genuri = new Genuri();
                genuri.setDenumire(resultSet.getString("g.denumire"));
                genuri.setId(resultSet.getInt("g.id"));
                books.setGenuri(genuri);

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;


    }

    public List<Books> findAll() {
        List<Books> booksList = new ArrayList<>();
        String query = "select c.id,c.denumire,c.editura,c.an_aparitie,a.id,a.nume,a.prenume,g.id,g.denumire " +
                "from carti c\n" +
                "inner join autor a on c.id_autor=a.id\n" +
                "inner join genuri g on c.id_gen=g.id\n";


        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Books books = new Books();
                books.setAn_aparitie(resultSet.getDate("c.an_aparitie"));
                books.setId(resultSet.getInt("c.id"));
                books.setDenumire(resultSet.getString("c.denumire"));
                books.setEditura(resultSet.getString("c.denumire"));

                Author author = new Author();
                author.setId(resultSet.getInt("a.id"));
                author.setName(resultSet.getString("a.nume"));
                author.setSurname(resultSet.getString("a.prenume"));
                books.setAuthor(author);


                Genuri genuri = new Genuri();
                genuri.setDenumire(resultSet.getString("g.denumire"));
                genuri.setId(resultSet.getInt("g.id"));
                books.setGenuri(genuri);
                booksList.add(books);

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return booksList;
    }

    public boolean save(Books books) {
        String query = "INSERT INTO carti(denumire,editura,id_gen,id_autor) VALUES(?,?,?,?)";
        Connection connection = null;

        try {
            connection=DriverManager.getConnection(connectionUrl,user,password);
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,books.getDenumire());
            preparedStatement.setString(2,books.getEditura());
            preparedStatement.setInt(3,books.getGenuri().getId());
            preparedStatement.setInt(4,books.getAuthor().getId());

           preparedStatement.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return true;
    }

  /*  public List<Books> findUnrentedBooks() {
        List<Books> booksList=new ArrayList<>();
        String query=
    }*/


}
