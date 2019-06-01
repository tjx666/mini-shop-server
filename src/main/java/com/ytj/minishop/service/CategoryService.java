package com.ytj.minishop.service;

import com.ytj.minishop.entity.Category;
import com.ytj.minishop.util.ServiceResult;

public interface CategoryService {
    ServiceResult create(Category category);
    ServiceResult getCategoryTrees();
}
