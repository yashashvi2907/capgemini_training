package org.example;

import java.sql.*;

public class PlayerService
{
    public static void main(String[] args) throws SQLException
    {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Khushi";

        Connection con = DriverManager.getConnection(url, user, password);

        Statement statement = con.createStatement();

        int rowsInserted = statement.executeUpdate(
                "INSERT INTO players VALUES (2, 'Smith', 'Aus')"
        );

        if (rowsInserted > 0)
            System.out.println(rowsInserted + " rows inserted");
        else
            System.out.println("Insert failed");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM players");

        while (resultSet.next())
        {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String country = resultSet.getString("playercountry");

            System.out.println(id + " | " + name + " | " + country);
        }

        con.close();
    }
}