package com.docker.xmpl.springdocker.dao;

import com.docker.xmpl.springdocker.BoatRepository;
import com.docker.xmpl.springdocker.model.Boat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoatDaoServiceImpl implements BoatDaoService {
    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> findAll() {
        return boatRepository.findAll();
    }

    public void save(Boat boat) {
        boatRepository.save(boat);
    }

}
