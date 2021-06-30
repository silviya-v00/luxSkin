package com.ss.luxSkin.repositories;

import com.ss.luxSkin.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login,Long>
{
    @Query("SELECT l FROM Login l WHERE lower(l.name) = :name ")
    Optional<Login> findLoginByName (String name);

    @Query("SELECT l FROM Login l WHERE l.name = :name AND l.password = :password")
    Optional<Login> findLoginByNameAndPassword (String name, String password);
}
