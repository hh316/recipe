package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {
    void insertCategoryBatch(@Param("categorys") List<Category> categoryList);
}
