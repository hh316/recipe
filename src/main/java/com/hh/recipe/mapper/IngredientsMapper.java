package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.Ingredients;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IngredientsMapper extends BaseMapper<Ingredients> {
    // 批量插入食材列表
    void insertIngredientsBatch(@Param("ingredients") List<Ingredients> ingredients);
}
