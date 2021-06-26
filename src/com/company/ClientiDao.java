package com.company;

import java.sql.*;

public class ClientiDao {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String password = "victor";

    public Client findById(int id) {
        Client client = new Client();
        String query = "Select id, nume, prenume, telefon, email, adresa from Clienti where id = " + id;

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                client.setId(resultSet.getInt(1));
                client.setName(resultSet.getString(2));
                client.setSurname(resultSet.getString(3));
                client.setPhone(resultSet.getInt(4));
                client.setEmail(resultSet.getString(5));
                client.setAddress(resultSet.getString(6));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return client;


    }


    public void save(Client client) {
        String query = "insert into clienti (nume, prenume, telefon, email, adresa) values (?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setInt(3, client.getPhone());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, client.getAddress());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteById(int id){
        String query = "delete from clienti where id = ?";

        try{
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
