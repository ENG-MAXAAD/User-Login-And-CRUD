package com.example.shop;

import java.sql.*;

public class Connection {
    public static java.sql.Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    public Connection(String sql_query)throws SQLException {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb" ,"root" , "");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_query);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
