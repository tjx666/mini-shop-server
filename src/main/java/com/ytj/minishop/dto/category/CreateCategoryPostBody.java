package com.ytj.minishop.dto.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryPostBody {
    private String name;
    private Long parent;
}
