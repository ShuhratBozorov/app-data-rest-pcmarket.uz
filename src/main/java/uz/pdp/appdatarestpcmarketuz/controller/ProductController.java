package uz.pdp.appdatarestpcmarketuz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appdatarestpcmarketuz.entity.Product;
import uz.pdp.appdatarestpcmarketuz.payload.ProductDto;
import uz.pdp.appdatarestpcmarketuz.payload.Result;
import uz.pdp.appdatarestpcmarketuz.service.ProductService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/api/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/api/product")
    public ResponseEntity<Result> addProduct(@RequestBody ProductDto productDto) {
        Result result = productService.addProduct(productDto);
        return ResponseEntity.status(result.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(result);
    }

    @PutMapping("/api/product/{id}")
    public ResponseEntity<Result> editProduct(@Valid @RequestBody ProductDto productDto, @PathVariable Integer id) {
        Result result = productService.editProduct(productDto, id);
        return ResponseEntity.status(result.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(result);
    }

    @DeleteMapping("/api/product/{id}")
    public ResponseEntity<Result> deleteProduct(@PathVariable Integer id) {
        Result result = productService.deleteProduct(id);
        return ResponseEntity.status(result.isSuccess() ? 202 : 409).body(result);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
