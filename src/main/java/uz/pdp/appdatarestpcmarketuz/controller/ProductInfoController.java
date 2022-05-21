package uz.pdp.appdatarestpcmarketuz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appdatarestpcmarketuz.entity.Product;
import uz.pdp.appdatarestpcmarketuz.entity.ProductInfo;
import uz.pdp.appdatarestpcmarketuz.payload.ProductDto;
import uz.pdp.appdatarestpcmarketuz.payload.ProductInfoDto;
import uz.pdp.appdatarestpcmarketuz.payload.Result;
import uz.pdp.appdatarestpcmarketuz.service.ProductInfoService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductInfoController {
    @Autowired
    ProductInfoService productInfoService;

    @GetMapping("/api/productInfos")
    public ResponseEntity<List<ProductInfo>> getProductInfos() {
        List<ProductInfo> productInfos = productInfoService.getProductInfos();
        return ResponseEntity.ok(productInfos);
    }

    @GetMapping("/api/productInfo/{id}")
    public ResponseEntity<ProductInfo> getProductInfoById(@PathVariable Integer id) {
        ProductInfo productInfo = productInfoService.getProductInfoById(id);
        return ResponseEntity.ok(productInfo);
    }

    @PostMapping("/api/productInfo")
    public ResponseEntity<Result> addProductInfo(@RequestBody ProductInfoDto productInfoDto) {
        Result result = productInfoService.addProductInfo(productInfoDto);
        return ResponseEntity.status(result.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(result);
    }

    @PutMapping("/api/productInfo/{id}")
    public ResponseEntity<Result> editProductInfo(@Valid @RequestBody ProductInfoDto productInfoDto, @PathVariable Integer id) {
        Result result = productInfoService.editProductInfo(productInfoDto, id);
        return ResponseEntity.status(result.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(result);
    }

    @DeleteMapping("/api/productInfo/{id}")
    public ResponseEntity<Result> deleteProductInfo(@PathVariable Integer id) {
        Result result = productInfoService.deleteProductInfo(id);
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
