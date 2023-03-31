package com.ctu.Library.Category;

import com.ctu.Library.Category.DTO.CategoryDTO;
import com.ctu.Library.Category.Mapper.CategoryMapper;
import com.ctu.Library.ExceptionHandling.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    
    public Category findById(long id) {return categoryRepository.findById(id).orElseThrow(()->new CustomException("Không tìm thấy loại sản phẩm với mã " + id, HttpStatus.NOT_FOUND));}

    
    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> result = new ArrayList<>();
        for(Category category : categoryRepository.findAll()){
            result.add(
                    categoryMapper.modelToDTO(category)
            );
        }
        return result;
    }
    public CategoryDTO addCategory(Category category){
        return categoryMapper.modelToDTO(categoryRepository.save(category));
    }
    public CategoryDTO updateCategory(Long id, Category newCategory){
        Category currentCategory = categoryRepository.findById(id).orElseThrow(() -> new CustomException("Không tìm thấy danh mục với mã " + id, HttpStatus.NOT_FOUND));
        currentCategory.setName(newCategory.getName());
        currentCategory.setDescription(newCategory.getDescription());
        Category saved = categoryRepository.save(currentCategory);
        return categoryMapper.modelToDTO(saved);
    }
}
