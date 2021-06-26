package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDB {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String password = "victor";

    public Author findById(int id) {
        Author author = new Author();

        String query = "select * " +
                "from autor where id =" + id;

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
                author.setSurname(resultSet.getString(3));
            }
            return author;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void save(Author author) {
        String query = "INSERT INTO autor(nume,prenume) VALUES(?,?)";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getSurname());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Author> getAll() {
        List<Author> authors = new ArrayList<>();
        String query = "Select * From autor";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
                author.setSurname(resultSet.getString(3));
                authors.add(author);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authors;

    }

    public void deleteById(int id) {
        String query = "DELETE FROM autor WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

