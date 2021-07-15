package ru.geekbrains.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.services.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/demo")
    @ResponseBody
    public String demo(){
        return "demo ОК";
    }

    @GetMapping("/app/products")
    public String showCart(Model model){
        model.addAttribute("productsList", productService.getProductList());
        return "productsList";
    }

    @GetMapping("/add")
    public String addProduct(){
        return "add_form";
    }

    @GetMapping("/app/products/{id}")
    public String infoOfProduct(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.findByID(id));
        return "infoProduct";
    }

    @GetMapping("/app/products/delete/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.deletedByID(id);
        return "productsList";
    }

    @PostMapping("/app/products")
    public String addNewProduct(@RequestParam String title, @RequestParam int price){
        productService.addNew(title, price);
        return "productsList";
    }

    @GetMapping("/app/products/minprice")
    @ResponseBody
    public List<Product> findAllByPriceGreaterThanEqual(@RequestParam int minPrice){
        return productService.findAllByPriceGreaterThanEqual(minPrice);
    }

    @GetMapping("/app/products/maxprice")
    @ResponseBody
    public List<Product> findAllByPriceLessThanEqual(@RequestParam int maxPrice){
        return productService.findAllByPriceLessThanEqual(maxPrice);
    }

    @GetMapping("/app/products/price_min_max")
    @ResponseBody
    public List<Product> findAllByPriceBetween(@RequestParam int min, @RequestParam int max){
        return productService.findAllByPriceBetween(min, max);
    }

//    @PostMapping("/add_new_product")
//    public String addNewProduct(Model model, @RequestParam int id, @RequestParam String title, @RequestParam int price){
//        String answer = productService.addNewProduct(id, title, price);
//        if(answer.startsWith("Добавлен")){
//            return "redirect:/repository";
//        }else {
//            model.addAttribute("answer", answer);
//            return "add_form";
//        }
//    }

}
