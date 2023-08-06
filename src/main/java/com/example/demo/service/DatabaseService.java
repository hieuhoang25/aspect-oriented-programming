package com.example.demo.service;

import com.example.demo.aspect.Log;
import com.example.demo.model.Database;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService {

    @Log
    public List<String>  connect(Database database) throws SQLException {
        String url = "jdbc:mysql://"+database.getHost()+":"+ database.getPort()+ "/?user="+database.getUsername()+"&password="+database.getPassword();
        Connection connection = DriverManager.getConnection(url);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SHOW DATABASES");
        List<String> databaseNames = new ArrayList<>();
        while (resultSet.next()){
            String row = resultSet.getString(1);
            databaseNames.add(row);
        }
        resultSet.close();
        statement.close();
        return databaseNames;
    }
}
