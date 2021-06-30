package com.ss.luxSkin.repositories;

import com.ss.luxSkin.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long>
{
    @Query("SELECT c FROM Client c WHERE lower(c.name) = :name ")
    Optional<Client>  findClientByName (String name);
}
