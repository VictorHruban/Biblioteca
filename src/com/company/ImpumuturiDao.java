package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpumuturiDao {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String password = "victor";

    public Rent findById(int id) {
        Rent rent = new Rent();
        String query = "Select id, data_imprumut, data_retur from imprumut where id = " + id;
        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rent.setId(resultSet.getInt(1));
                rent.setData_imprumut(resultSet.getInt(2));
                rent.setData_retur(resultSet.getInt(3));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rent;

    }

    public List<Rent> getAll() {
        List<Rent> rents = new ArrayList<>();
        String query = "select*from imprumut";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rent rent = new Rent();
                rent.setId(resultSet.getInt(1));
                rent.setData_imprumut(resultSet.getInt(2));
                rent.setData_retur(resultSet.getInt(3));


                rents.add(rent);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rents;

    }

    public void save (Rent rent) {
        String query = "insert into imprumut (data_imprumut, data_retur) values (?, ?)";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(2, rent.getData_imprumut());
            preparedStatement.setInt(4, rent.getData_retur());


            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    }

