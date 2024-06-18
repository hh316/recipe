package com.hh.recipe.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hh.recipe.domain.dto.RecipeDto;
import com.hh.recipe.domain.po.*;
import com.hh.recipe.mapper.*;
import com.hh.recipe.service.RecipeService;
import com.hh.recipe.utils.Result;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl extends ServiceImpl<RecipeMapper, Recipe> implements RecipeService {

    //菜谱
    private final RecipeMapper recipeMapper;
    //食材
    private final IngredientsMapper ingredientsMapper;
    //配料
    private final BatchingsMapper batchingsMapper;
    //步骤
    private final CookingStepMapper cookingStepMapper;
    //分类
    private final CategoryMapper categoryMapper;

    //创建菜谱
    @Override
    public Result create(RecipeDto recipeDto) {
        //根据前端传来的菜谱dto实体分别创建菜谱，食材，配料，步骤，分类
        //1.添加菜谱
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeDto.getRecipeName());
        recipe.setRecipeImage(recipeDto.getRecipeImage());
        recipe.setRecipeDescription(recipeDto.getRecipeDescription());
        Date date = new Date();
        recipe.setCreateTime(new Timestamp(date.getTime()));
        recipe.setRecipeExperience(recipeDto.getRecipeExperience());
        //TODO-完善登录功能后，从token中获得创建者id
        recipe.setCreatorId(1);
        //mybatis-plus单表的添加
        recipeMapper.insert(recipe);
        Integer recipeId = recipe.getRecipeId();
        System.out.println("菜谱的主键id:" + recipeId);
        //2.添加食材
        //2.1先获取食材的集合
        List<Ingredients> ingredientsList = recipeDto.getIngredients();

        //2.2设置菜谱id
        for (Ingredients ingredient : ingredientsList) {
            ingredient.setRecipeId(recipeId);
        }
        System.out.println("食材集合:" + ingredientsList);
        //2.3插入食材
        ingredientsMapper.insertIngredientsBatch(ingredientsList);

        //3.添加配料
        //3.1从前端的dto里获得配料的集合
        List<Batchings> batchingsList = recipeDto.getBatchings();

        //3.2设置菜谱id
        for (Batchings batching : batchingsList) {
            batching.setRecipeId(recipeId);
        }
        System.out.println("配料集合:" + batchingsList);
        batchingsMapper.insertBatingsBatch(batchingsList);
        //4.添加步骤
        //4.1从前端获取步骤
        final List<CookingStep> cookingStepList = recipeDto.getCookingSteps();
        //4.2设置菜谱id
        for (CookingStep cookingStep : cookingStepList) {
            cookingStep.setRecipeId(recipeId);
        }
        System.out.println("步骤集合:" + cookingStepList);
        cookingStepMapper.insertCookingStepBatch(cookingStepList);

        //5.设置分类
        //5.1从dto中获得分类实体
        final List<Category> categoryList = recipeDto.getCategories();
        //5.2设置菜谱id
        for (Category category : categoryList) {
            category.setRecipeId(recipeId);
        }
        System.out.println("分类集合:" + categoryList);
        categoryMapper.insertCategoryBatch(categoryList);
        return Result.ok(null);
    }
}