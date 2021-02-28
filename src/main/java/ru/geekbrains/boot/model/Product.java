package ru.geekbrains.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Product {
    private static int iid=0;
    private int id;
    private String title;
    private int cost;


    public Product(String title, int cost) {
        iid++;
        this.id = iid;
        this.title = title;
        this.cost = cost;
    }

}
