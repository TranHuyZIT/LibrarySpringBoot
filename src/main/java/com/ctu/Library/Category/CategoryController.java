package com.ctu.Library.Category;

import com.ctu.Library.Category.DTO.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody Category newCategory){
        return categoryService.updateCategory(id, newCategory);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category getOne(@PathVariable Long id){
        return categoryService.findById(id);
    }
}

