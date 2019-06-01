package com.ytj.minishop.service.impl;

import com.ytj.minishop.dto.category.CategoryTreeNode;
import com.ytj.minishop.entity.Category;
import com.ytj.minishop.repository.CategoryRepository;
import com.ytj.minishop.service.CategoryService;
import com.ytj.minishop.util.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ServiceResult create(Category category) {
        category = this.categoryRepository.save(category);

        if (category.getParent() != null) {
            Optional<Category> parentCategoryOptional = categoryRepository.findById(category.getParent());
            if (parentCategoryOptional.isPresent()) {
                Category parentCategory = parentCategoryOptional.get();
                String originalChildren = parentCategory.getChildren();
                parentCategory.setChildren((originalChildren == null ? "" : originalChildren + ",") + category.getId());
                categoryRepository.save(parentCategory);
            } else {
                return ServiceResult.fail("不存在指定id(" + category.getParent() + ")的父类");
            }
        }

        return new ServiceResult(0);
    }

    @Override
    public ServiceResult<CategoryTreeNode[]> getCategoryTrees() {
        List<Category> categories = categoryRepository.findAll();
        List<Category> level1Categories = categories.stream()
                .filter(category -> category.getParent() == null)
                .collect(Collectors.toList());

        // 获取所有的一级类节点，其实就是树的根节点，总共三级类，这里就不用递归了
        CategoryTreeNode[] categoryTrees = level1Categories
                .stream()
                .map(level1Category -> {
                    CategoryTreeNode level1Node = new CategoryTreeNode();
                    level1Node.setId(level1Category.getId());
                    level1Node.setName(level1Category.getName());

                    // 处理二级类
                    CategoryTreeNode[] Level2children = Stream
                            .of(level1Category.getChildren().split(","))
                            .map(level2Child -> {
                                Optional<Category> optionalLevel2Category = categoryRepository.findById(Long.valueOf(level2Child));
                                if (!optionalLevel2Category.isPresent()) {
                                    throw new RuntimeException("找不到 id=" + level2Child + " 的二级类");
                                } else {
                                    Category level2Category = optionalLevel2Category.get();
                                    CategoryTreeNode level2Node = new CategoryTreeNode();
                                    level2Node.setId(level2Category.getId());
                                    level2Node.setName(level2Category.getName());
                                    level2Node.setParent(level1Category.getId());

                                    CategoryTreeNode[] level3Children = Stream
                                            .of(level2Category.getChildren().split(","))
                                            .map(level3Child -> {
                                                Optional<Category> optionalLevel3Category = categoryRepository.findById(Long.valueOf(level3Child));
                                                if (!optionalLevel3Category.isPresent()) {
                                                    throw new RuntimeException("找不到 id=" + level3Child + " 的三级类");
                                                } else {
                                                    Category level3Category = optionalLevel3Category.get();
                                                    CategoryTreeNode level3Node = new CategoryTreeNode();
                                                    level3Node.setId(level3Category.getId());
                                                    level3Node.setName(level3Category.getName());
                                                    level3Node.setParent(level3Category.getParent());
                                                    return level3Node;
                                                }
                                            })
                                            .toArray(CategoryTreeNode[]::new);

                                    level2Node.setChildren(level3Children);
                                    return level2Node;
                                }
                            }).toArray(CategoryTreeNode[]::new);

                    level1Node.setChildren(Level2children);
                    return level1Node;
                })
                .toArray(CategoryTreeNode[]::new);

        return new ServiceResult<CategoryTreeNode[]>(0, "获取3级类别树成功!", categoryTrees);
    }
}
