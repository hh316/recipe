package com.hh.recipe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.recipe.domain.dto.RecipeDto;
import com.hh.recipe.domain.po.Recipe;
import com.hh.recipe.utils.Result;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService extends IService<Recipe> {
    Result create(RecipeDto recipeDto);
    //创建菜谱


}