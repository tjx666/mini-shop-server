package com.ytj.minishop.service.impl;

import com.ytj.minishop.entity.Category;
import com.ytj.minishop.repository.CategoryRepository;
import com.ytj.minishop.service.CategoryService;
import com.ytj.minishop.util.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ServiceResult create(Category category) {
        if (category.getParent() != null) {
            Optional<Category> parentCategoryOptional = categoryRepository.findById(category.getParent());
            if (parentCategoryOptional.isPresent()) {
                Category parentCategory = parentCategoryOptional.get();
                String originalChildren = parentCategory.getChildren();
                parentCategory.setChildren((originalChildren == null ? "" : originalChildren + ",") + category.getName());
                categoryRepository.save(parentCategory);
            } else {
                return ServiceResult.fail("不存在指定id(" + category.getParent() + ")的父类");
            }
        }
        this.categoryRepository.save(category);
        return new ServiceResult(0);
    }
}
