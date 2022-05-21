package uz.pdp.appdatarestpcmarketuz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appdatarestpcmarketuz.entity.Brand;
import uz.pdp.appdatarestpcmarketuz.entity.Category;
import uz.pdp.appdatarestpcmarketuz.entity.Product;
import uz.pdp.appdatarestpcmarketuz.entity.ProductInfo;
import uz.pdp.appdatarestpcmarketuz.payload.ProductDto;
import uz.pdp.appdatarestpcmarketuz.payload.ProductInfoDto;
import uz.pdp.appdatarestpcmarketuz.payload.Result;
import uz.pdp.appdatarestpcmarketuz.repository.ProductInfoRepository;
import uz.pdp.appdatarestpcmarketuz.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    @Autowired
    ProductRepository productRepository;

    public List<ProductInfo> getProductInfos() {
        return productInfoRepository.findAll();
    }

    public ProductInfo getProductInfoById(Integer id) {
        Optional<ProductInfo> optionalProductInfo = productInfoRepository.findById(id);
        return optionalProductInfo.orElse(null);
    }

    public Result addProductInfo(ProductInfoDto productInfoDto) {

        Optional<Product> optionalProduct = productRepository.findById(productInfoDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Bunday product mavjud emas!", false);

        ProductInfo productInfo = new ProductInfo();
        productInfo.setKey(productInfoDto.getKey());
        productInfo.setKey(productInfoDto.getValue());
        productInfo.setProduct(optionalProduct.get());
        productInfoRepository.save(productInfo);
        return new Result("ProductInfo added", true);
    }

    public Result editProductInfo(ProductInfoDto productInfoDto, Integer id) {

        Optional<ProductInfo> optionalProductInfo = productInfoRepository.findById(id);
        if (!optionalProductInfo.isPresent())
            return new Result("Bunday productInfo mavjud emas", false);

        Optional<Product> optionalProduct = productRepository.findById(productInfoDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Bunday product mavjud emas!", false);
        Product product = optionalProduct.get();


        ProductInfo productInfo = optionalProductInfo.get();
        productInfo.setKey(productInfoDto.getKey());
        productInfo.setValue(productInfoDto.getValue());
        productInfo.setProduct(product);
        productInfoRepository.save(productInfo);
        return new Result("ProductInfo edited", true);
    }

    public Result deleteProductInfo(Integer id) {
        try {
            productInfoRepository.deleteById(id);
            return new Result("ProductInfo deleted", true);
        } catch (Exception e) {
            return new Result("Error!!!", false);
        }
    }
}
