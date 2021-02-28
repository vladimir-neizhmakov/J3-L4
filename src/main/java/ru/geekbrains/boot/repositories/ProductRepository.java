package ru.geekbrains.boot.repositories;

import ru.geekbrains.boot.Interfaces.ProductRepositoryInterface;
import ru.geekbrains.boot.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;


@Component
public class ProductRepository implements ProductRepositoryInterface {
   private List<Product> products;

   @PostConstruct
   public void init() {
      products = new ArrayList<>();
      products.add(new Product("Milk", 36));
      products.add(new Product("Bread", 43));
      products.add(new Product("Carrot", 17));
      products.add(new Product("Burger", 112));
      products.add(new Product("Ketchup", 72));
   }


   @Override
   public List<Product> getProducts() {
      return Collections.unmodifiableList(products);
   }

   @Override
   public void addProduct(Product product) {
      if (product.getCost() < 0) {
         throw new IllegalArgumentException("Product's score must be > 0");
      }
      products.add(product);
   }

   @Override
   public void updateProduct(int id, String newtitle, int newcost) {
      if (newcost < 0) {
         throw new IllegalArgumentException("Product's score must be > 0");
      }
      products.get(id).setTitle(newtitle);
      products.get(id).setCost(newcost);
   }

   @Override
   public void deleteProduct(int id) {
      products.remove(id);
   }

   public int getListID(int productID){
      for (Product p : products) {if(p.getId()==productID){return products.indexOf(p);}
      }
      return productID;
   }


}

