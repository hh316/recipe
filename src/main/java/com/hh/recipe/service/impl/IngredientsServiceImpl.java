package com.hh.recipe.service.impl;

import com.hh.recipe.domain.vo.IngredientsVo;
import com.hh.recipe.mapper.IngredientsMapper;
import com.hh.recipe.service.IngredientsService;
import com.hh.recipe.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//食材业务层
@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {
    private final IngredientsMapper ingredientsMapper;

    /**
     * @param recipeId
     * @return 查询菜谱里的食材
     */
    @Override
    public Result selectIngredientsByRecipeId(int recipeId) {
        ArrayList<IngredientsVo> ingredientsVoArrayList = new ArrayList<>();
        ingredientsVoArrayList = ingredientsMapper.selectIngredientsByRecipeId(recipeId);
        return Result.ok(ingredientsVoArrayList);
    }
}
