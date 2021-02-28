package ru.geekbrains.boot.services;

import ru.geekbrains.boot.model.Product;
import ru.geekbrains.boot.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

 //   @Autowired
 //   public void SetProductRepository(ProductRepository productRepository){this.productRepository = productRepository;}

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public void addProduct(Product product) {productRepository.addProduct(product);}

    public void updateProduct(int id, String newtitle, int newcost) {
        productRepository.updateProduct(id,newtitle,newcost);
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public int getListID(int productID){
        return productRepository.getListID(productID);
    }

    public int productCount(){
        return productRepository.getProducts().size();
    }

    public double productAverageCost(){
        double avg=0;
        for (Product p : productRepository.getProducts()) {
            avg += p.getCost();
        }
        avg /= productRepository.getProducts().size();
        return avg;
    }

}
