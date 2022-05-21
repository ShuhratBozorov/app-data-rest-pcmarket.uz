package uz.pdp.appdatarestpcmarketuz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appdatarestpcmarketuz.entity.Category;
import uz.pdp.appdatarestpcmarketuz.payload.CategoryDto;
import uz.pdp.appdatarestpcmarketuz.payload.Result;
import uz.pdp.appdatarestpcmarketuz.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }

    public Result addCategory(CategoryDto categoryDto) {
        boolean exists = categoryRepository.existsByName(categoryDto.getName());
        if (exists)
            return new Result("Bunday nomli category mavjud", false);

        Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
        if (!optionalParentCategory.isPresent())
            return new Result("Bunday parentCategory mavjud emas!", false);
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setActive(category.isActive());
        category.setParentCategory(optionalParentCategory.get());
        categoryRepository.save(category);
        return new Result("Category added", true);
    }

    public Result editCategory(CategoryDto categoryDto, Integer id) {
        boolean exists = categoryRepository.existsByName(categoryDto.getName());
        if (exists)
            return new Result("Bunday nomli category mavjud", false);

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("Bunday category mavjud emas",false);

        Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
        if (!optionalParentCategory.isPresent())
            return new Result("Bunday parentCategory mavjud emas!", false);

        Category parentCategory = optionalParentCategory.get();

        Category category = optionalCategory.get();
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.isActive());
        category.setParentCategory(parentCategory);
        categoryRepository.save(category);
        return new Result("Category edited", true);
    }

    public Result deleteCategory(Integer id) {
        try {
            categoryRepository.deleteById(id);
            return new Result("Category deleted", true);
        } catch (Exception e) {
            return new Result("Error!!!", false);
        }
    }


}
