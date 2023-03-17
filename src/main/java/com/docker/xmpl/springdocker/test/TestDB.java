package com.docker.xmpl.springdocker.test;

import com.docker.xmpl.springdocker.BoatRepository;
import com.docker.xmpl.springdocker.dao.BoatDaoServiceImpl;
import com.docker.xmpl.springdocker.model.Boat;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestDB {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/boats?user=root&password=hello");
        String query = "SELECT * FROM boats";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<Boat> list = new ArrayList<>();
        while (rs.next()){
            Boat boat = new Boat();
            UUID id = UUID.fromString(rs.getNString ("id"));
            String name = rs.getNString("name");
            boat.setId(id);
            boat.setName(name);
            list.add(boat);
            Gson gson = new Gson();
            System.out.println("gson.toJson(boat) = " + gson.toJson(boat));
        }




        list.stream()
                .forEach(System.out::println);

    }
}
