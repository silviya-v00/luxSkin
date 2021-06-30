package com.ss.luxSkin.entities;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "count_client")
    private Integer count_client;

    @Column(name = "price")
    private String price;

    public Client() {
    }

    public Client(Long id, String name, String email, String product_name, Integer count_client, String price) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.product_name = product_name;
        this.count_client = count_client;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getCount_client() {
        return count_client;
    }

    public void setCount_client(Integer count_client) {
        this.count_client = count_client;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}



