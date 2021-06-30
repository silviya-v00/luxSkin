package com.ss.luxSkin.repositories;

import com.ss.luxSkin.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long>
{
    @Query("SELECT p FROM Product p WHERE lower(p.name) = :name")
    Optional<Product> findProductByName(String name);

    Product findProductById(Long id);
}

