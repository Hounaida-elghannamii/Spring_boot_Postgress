package com.example.postgre;

import jakarta.persistence.*;

@Entity
@Table(name = "mt_exemple")
public class DeviseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "currencyname")
    private String CurrencyName;
    @Column(name = "price")
    private String Price;
    @Column(name = "date_de_update")
    private String DatedeUpp;


    public DeviseEntity() {
    }

    public DeviseEntity(String CurrencyName, String Price, String DatedeUpp) {
        this.CurrencyName = CurrencyName;
        this.Price = Price;
        this.DatedeUpp = DatedeUpp;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String name) {
        this.CurrencyName = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String gender) {
        this.Price = gender;
    }

    public String getDatedeUpp() {
        return DatedeUpp;
    }

    public void setDatedeUpp(String date) {
        this.DatedeUpp = date;
    }

}
