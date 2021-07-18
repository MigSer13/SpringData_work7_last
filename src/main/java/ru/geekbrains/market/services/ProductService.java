package ru.geekbrains.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public String addNewProduct(Long id, String title, int price){
//        if(id == 0 || id < 0){
//            return "id не указан или меньше 0";
//        }else if(title.equals("")){
//            return "title не указан";
//        }else if(price < 0){
//            return "цена не может быть меньше 0";
//        }
//
//        return productRepository.addProduct(id, title, price);
//    }

    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    public Product findByID(Long id){
        return productRepository.findById(id).get();
    }

    public void deletedByID(Long id){
        productRepository.deleteById(id);
    }

    public void addNew(String title, int price){
        productRepository.findAll().add(new Product(title, price));
    }

    public List<Product> findAllByPriceGreaterThanEqual(int minPrice){
        return productRepository.findAllByPriceGreaterThanEqual(minPrice);
    }

    public List<Product> findAllByPriceLessThanEqual(int maxPrice){
        return productRepository.findAllByPriceLessThanEqual(maxPrice);
    }

    public List<Product> findAllByPriceBetween(int minPrice, int maxPrice){
        return productRepository.findAllByPriceBetween(minPrice, maxPrice);
    }

    public Page<Product> findPage(int page, int size){
        return productRepository.findAll(PageRequest.of(page, size));
    }
}
