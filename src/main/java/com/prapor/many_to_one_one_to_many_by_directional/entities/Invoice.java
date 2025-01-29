package com.prapor.many_to_one_one_to_many_by_directional.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="number")
    private int number;

    @Column(name = "date")
    private String date;

    @Column(name = "month")
    private String month;

    @Column(name = "from_whom_to_whom")
    private String fromWhom_toWhom;

    @Column(name = "come_gone")
    private String come_gone;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @OneToMany(cascade = CascadeType.ALL
        ,mappedBy = "invoice")
    private List<Product> productList;

    public Invoice() {
    }

    public Invoice(int number, String date, String month, String fromWhom_toWhom, String come_gone) {
        this.number = number;
        this.date = date;
        this.month = month;
        this.fromWhom_toWhom = fromWhom_toWhom;
        this.come_gone = come_gone;
    }

    public Invoice(int number, String date, String month, String fromWhom_toWhom,
                   String come_gone, Storage storage, List<Product> products) {
        this.number = number;
        this.date = date;
        this.month = month;
        this.fromWhom_toWhom = fromWhom_toWhom;
        this.come_gone = come_gone;
        this.storage = storage;
        this.productList = products;
    }

    public void addProductToProductList(Product product){
        if(productList == null){
            productList = new ArrayList<>();
        }
        productList.add(product);
        product.setInvoice(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getFromWhom_toWhom() {
        return fromWhom_toWhom;
    }

    public void setFromWhom_toWhom(String fromWhom_toWhom) {
        this.fromWhom_toWhom = fromWhom_toWhom;
    }

    public String getCome_gone() {
        return come_gone;
    }

    public void setCome_gone(String come_gone) {
        this.come_gone = come_gone;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", number=" + number +
                ", date='" + date + '\'' +
                ", month='" + month + '\'' +
                ", fromWhom_toWhom='" + fromWhom_toWhom + '\'' +
                ", come_gone='" + come_gone + '\'' +
                '}';
    }
}
