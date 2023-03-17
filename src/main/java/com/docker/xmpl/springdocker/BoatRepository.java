package com.docker.xmpl.springdocker;

import com.docker.xmpl.springdocker.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BoatRepository extends JpaRepository<Boat, UUID> {

    Boat findByName(String name);
}
