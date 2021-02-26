package ru.geekbrains.boot.controllers;

import lombok.RequiredArgsConstructor;
import ru.geekbrains.boot.model.Product;
import ru.geekbrains.boot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// root: http://localhost:8189/app/p

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("avgCost", productService.productAverageCost());
        model.addAttribute("count", productService.productCount());
        return "all_products";}

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/remove/{id}")
    public String deleteProductById(@PathVariable int id) {
        productService.deleteProduct(productService.getListID(id));
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProducts().get(productService.getListID(id)));
        return "edit_product_form";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute(name = "id") int id, @ModelAttribute(name = "title") String title, @ModelAttribute(name = "cost") int cost) {
        productService.updateProduct(productService.getListID(id), title, cost);
        return "redirect:/products/";
    }

}