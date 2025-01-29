package com.prapor.many_to_one_one_to_many_by_directional.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "liters")
    private int liters;

    @Column(name = "kg")
    private int kg;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;


    public Product() {
    }

    public Product(String code, String name, int liters, int kg) {
        this.code = code;
        this.name = name;
        this.liters = liters;
        this.kg = kg;
    }

    public Product(String code, String name, int liters, int kg, Invoice invoice) {
        this.code = code;
        this.name = name;
        this.liters = liters;
        this.kg = kg;
        this.invoice = invoice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLiters() {
        return liters;
    }

    public void setLiters(int liters) {
        this.liters = liters;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
