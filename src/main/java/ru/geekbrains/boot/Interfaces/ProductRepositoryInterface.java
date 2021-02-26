package ru.geekbrains.boot.Interfaces;

import ru.geekbrains.boot.model.Product;

import java.util.List;

public interface ProductRepositoryInterface {
    List<Product> getProducts();
    void addProduct(Product product);
    void updateProduct(int id, String newtitle, int newcost);
    void deleteProduct(int id);
}
