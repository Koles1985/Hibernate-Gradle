package one_to_one_ratio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "code")
    int code;

    @Column(name = "name")
    String name;

    @Column(name = "liters")
    int liters;

    @Column(name = "kg")
    int kg;


    public Product() {
    }

    public Product(int code, String name, int liters, int kg) {
        this.code = code;
        this.name = name;
        this.liters = liters;
        this.kg = kg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", liters=" + liters +
                ", kg=" + kg +
                '}';
    }
}
