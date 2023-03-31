package com.ctu.Library.Category.Mapper;

import com.ctu.Library.Category.Category;
import com.ctu.Library.Category.DTO.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category dtoToModel(CategoryDTO categoryDTO);
    CategoryDTO modelToDTO(Category category);

}
