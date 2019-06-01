package com.ytj.minishop.controller;

import com.ytj.minishop.dto.category.CreateCategoryPostBody;
import com.ytj.minishop.entity.Category;
import com.ytj.minishop.service.impl.CategoryServiceImpl;
import com.ytj.minishop.util.Result;
import com.ytj.minishop.util.ResultGenerator;
import com.ytj.minishop.util.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/categories")
@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @PutMapping(value = "")
    public Result createCategory(@RequestBody CreateCategoryPostBody body) {
        Category category = new Category(body.getName(), body.getParent());
        ServiceResult result = categoryService.create(category);
        if (result.getCode() == 0) {
            return ResultGenerator.genSuccessResult(category);
        } else {
            return ResultGenerator.genFailResult(result.getMessage());
        }

    }
}
