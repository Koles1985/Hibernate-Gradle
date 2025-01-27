package one_to_one_ratio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "number")
    int number;

    @Column(name = "date")
    String date;

    @Column(name = "month")
    String month;


    @Column(name = "from_whom_to_whom")
    String fromWhomToWhom;

    @Column(name = "coming_consumption")
    String coming_consumption;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    Product product;

    public Invoice() {
    }

    public Invoice(int number, String date, String month,
                   String fromWhomToWhom, String coming_consumption, Product product) {
        this.number = number;
        this.date = date;
        this.month = month;
        this.fromWhomToWhom = fromWhomToWhom;
        this.coming_consumption = coming_consumption;
        this.product = product;
    }

    public Invoice(int number, String date, String month,
                   String fromWhomToWhom, String coming_consumption) {
        this.number = number;
        this.date = date;
        this.month = month;
        this.fromWhomToWhom = fromWhomToWhom;
        this.coming_consumption = coming_consumption;

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

    public String getFromWhomToWhom() {
        return fromWhomToWhom;
    }

    public void setFromWhomToWhom(String fromWhomToWhom) {
        this.fromWhomToWhom = fromWhomToWhom;
    }

    public String getComing_consumption() {
        return coming_consumption;
    }

    public void setComing_consumption(String coming_consumption) {
        this.coming_consumption = coming_consumption;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", number=" + number +
                ", date='" + date + '\'' +
                ", month='" + month + '\'' +
                ", fromWhomToWhom='" + fromWhomToWhom + '\'' +
                ", coming_consumption='" + coming_consumption + '\'' +
                ", product=" + product.toString() +
                '}';
    }
}
