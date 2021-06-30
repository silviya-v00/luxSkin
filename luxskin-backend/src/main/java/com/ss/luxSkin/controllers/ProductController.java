package com.ss.luxSkin.controllers;

import com.ss.luxSkin.entities.Product;
import com.ss.luxSkin.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam Long id) {

        if(!productRepository.existsById(id))
        {
            return ResponseEntity.ok("Няма такъв продукт!");
        }

        productRepository.deleteById(id);
        return ResponseEntity.ok("Изтрит успешно!");
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestParam(required = false) Long id,
                                         @RequestParam(required = false) String name,
                                         @RequestParam(required = false) String description,
                                         @RequestParam(required = false) String price){
        boolean isNew = id == null;

        Product product = new Product(id, name, description, price);
        product = productRepository.save(product);
        Map<String, Object> response = new HashMap<>();
        response.put("generatedId", product.getId());
        if (isNew){
            response.put("message", "Успешно записан!");
        }
        else {
            response.put("message", "Успешно редактиран!");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/search")
    public ResponseEntity getId(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return ResponseEntity.ok().body("Не сте въвели име на продукт");
        }
        Optional<Product> result = productRepository.findProductByName(name.toLowerCase());
        return result.isPresent()?ResponseEntity.ok(result.get()) : ResponseEntity.ok("Няма намерен продукт!");
    }

    @GetMapping("/search/id")
    public Product getProductById(@RequestParam(required = false) Long id) {return productRepository.findProductById(id);}

    @GetMapping("/search/name")
    public Optional<Product> getProductByName(@RequestParam(required = false) String name) {return productRepository.findProductByName(name);}

}