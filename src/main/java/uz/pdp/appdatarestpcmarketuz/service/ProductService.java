package uz.pdp.appdatarestpcmarketuz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appdatarestpcmarketuz.entity.Brand;
import uz.pdp.appdatarestpcmarketuz.entity.Category;
import uz.pdp.appdatarestpcmarketuz.entity.Product;
import uz.pdp.appdatarestpcmarketuz.payload.ProductDto;
import uz.pdp.appdatarestpcmarketuz.payload.Result;
import uz.pdp.appdatarestpcmarketuz.repository.BrandRepository;
import uz.pdp.appdatarestpcmarketuz.repository.CategoryRepository;
import uz.pdp.appdatarestpcmarketuz.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public Result addProduct(ProductDto productDto) {

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Bunday category mavjud emas!", false);

        Optional<Brand> optionalBrand = brandRepository.findById(productDto.getBrandId());
        if (!optionalCategory.isPresent())
            return new Result("Bunday brand mavjud emas!", false);

        Product product = new Product();
        product.setName(productDto.getName());
        product.setCategory(optionalCategory.get());
        product.setBrand(optionalBrand.get());
        productRepository.save(product);
        return new Result("Product added", true);
    }

    public Result editProduct(ProductDto productDto, Integer id) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new Result("Bunday product mavjud emas", false);

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Bunday category mavjud emas!", false);
        Category category = optionalCategory.get();

        Optional<Brand> optionalBrand = brandRepository.findById(productDto.getBrandId());
        if (!optionalCategory.isPresent())
            return new Result("Bunday brand mavjud emas!", false);
        Brand brand = optionalBrand.get();

        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setBrand(brand);
        productRepository.save(product);
        return new Result("Product edited", true);
    }

    public Result deleteProduct(Integer id) {
        try {
            productRepository.deleteById(id);
            return new Result("Product deleted", true);
        } catch (Exception e) {
            return new Result("Error!!!", false);
        }
    }
}
