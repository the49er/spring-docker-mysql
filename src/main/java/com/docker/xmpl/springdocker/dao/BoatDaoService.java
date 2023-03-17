package com.docker.xmpl.springdocker.dao;
import com.docker.xmpl.springdocker.model.Boat;

import java.util.List;

public interface BoatDaoService {
    void save (Boat boat);
    List<Boat> findAll();
}
