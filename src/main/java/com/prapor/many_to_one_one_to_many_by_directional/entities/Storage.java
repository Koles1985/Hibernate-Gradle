package com.prapor.many_to_one_one_to_many_by_directional.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "storage")
    private List<Invoice> invoices;

    public Storage() {
    }

    public Storage(String name) {
        this.name = name;
    }

    public void addInvoiceToStorage(Invoice invoice){
        if(invoices == null) {
            invoices = new ArrayList<>();
        }
        invoices.add(invoice);
        invoice.setStorage(this);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", invoices=" + invoices +
                '}';
    }
}
