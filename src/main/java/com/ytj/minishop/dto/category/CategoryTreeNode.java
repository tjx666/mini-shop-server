package com.ytj.minishop.dto.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryTreeNode {
    private Long id;
    private String name;
    private Long parent;
    private CategoryTreeNode[] children;
}
