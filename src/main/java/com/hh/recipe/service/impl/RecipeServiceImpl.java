package com.hh.recipe.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hh.recipe.domain.dto.CreateRecipeDto;
import com.hh.recipe.domain.po.*;
import com.hh.recipe.domain.vo.RecipeDetailVo;
import com.hh.recipe.domain.vo.ShowRecipeVo;
import com.hh.recipe.mapper.*;
import com.hh.recipe.service.RecipeService;
import com.hh.recipe.utils.JwtHelper;
import com.hh.recipe.utils.Result;
import com.hh.recipe.utils.TokenContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//菜谱业务层
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
    private final JwtHelper jwtHelper;

    //创建菜谱
    @Override
    public Result create(CreateRecipeDto recipeDto) {
        //根据前端传来的菜谱dto实体分别创建菜谱，食材，配料，步骤，分类
        //1.添加菜谱
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeDto.getRecipeName());
        recipe.setRecipeImage(recipeDto.getRecipeImage());
        recipe.setRecipeDescription(recipeDto.getRecipeDescription());
        Date date = new Date();
        recipe.setCreateTime(new Timestamp(date.getTime()));
        recipe.setRecipeExperience(recipeDto.getRecipeExperience());
        //-完善登录功能后，从token中获得创建者id
//        System.out.println("从token中获取的recipe_id:" + jwtHelper.getUserId(token));
        System.out.println("从线程池中获得token:" + TokenContextHolder.getToken());
//        recipe.setCreatorId(jwtHelper.getUserId(token));
        recipe.setCreatorId(jwtHelper.getUserId(TokenContextHolder.getToken()));
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


    /**
     * @param recipeId 根据菜谱id显示菜谱详细信息
     */
    @Override
    public Result recipeDetail(int recipeId) {
        RecipeDetailVo recipeDetailVo = recipeMapper.recipeDetail(recipeId);
        return Result.ok(recipeDetailVo);
    }

    /**
     * @param recipeName
     * @return * @return 通过菜谱名称查菜谱
     */
    @Override
    public Result recipeDetailByRecipeName(String recipeName) {
        ArrayList<ShowRecipeVo> showRecipeVos = new ArrayList<>();
        showRecipeVos = recipeMapper.showRecipeByRecipeName(recipeName);
        return Result.ok(showRecipeVos);
    }

    /**
     * @param ingredientName
     * @return 通过食材名称查菜谱
     */
    @Override
    public Result recipeDetailByIngredientName(String ingredientName) {
        ArrayList<ShowRecipeVo> showRecipeVoArrayList = new ArrayList<>();
        System.out.println(showRecipeVoArrayList);
        showRecipeVoArrayList = recipeMapper.showRecipeByIngredientName(ingredientName);
        System.out.println(showRecipeVoArrayList);
        return Result.ok(showRecipeVoArrayList);
    }

    /**
     * @param categoryName
     * @return 通过分类名称查菜谱
     */
    @Override
    public Result recipeDetailByCategoryName(String categoryName) {
        ArrayList<ShowRecipeVo> showRecipeVoArrayList = new ArrayList<>();
        showRecipeVoArrayList = recipeMapper.showRecipeByCategoryName(categoryName);
        System.out.println(showRecipeVoArrayList);
        return Result.ok(showRecipeVoArrayList);
    }

    /**
     * @return 通过用户id查询点赞菜谱
     */
    @Override
    public Result recipeLikesByRecipeId() {
        Integer userId = jwtHelper.getUserId(TokenContextHolder.getToken());
        ArrayList<ShowRecipeVo> favoritesRecipeVoArrayList = new ArrayList<>();
        favoritesRecipeVoArrayList = recipeMapper.readRecipeLikesByRecipeIdRecipe(userId);
        System.out.println("点赞的菜谱:" + favoritesRecipeVoArrayList);
        return Result.ok(favoritesRecipeVoArrayList);
    }


    /**
     * 查看收藏的菜谱
     */

    @Override
    public Result recipeFavoritesByRecipeId() {
        Integer userId = jwtHelper.getUserId(TokenContextHolder.getToken());
        ArrayList<ShowRecipeVo> favoritesRecipeVoArrayList = new ArrayList<>();
        favoritesRecipeVoArrayList = recipeMapper.recipeFavoritesByRecipeId(userId);
        System.out.println("收藏的菜谱:" + favoritesRecipeVoArrayList);
        return Result.ok(favoritesRecipeVoArrayList);
    }

    /**
     * @param recipeId
     * @return 根据菜谱id查询收藏数量
     */
    @Override
    public Result favoritesByRecipeId(int recipeId) {
        Integer favoritesNumber = recipeMapper.favoritesByRecipeId(recipeId);
        if (favoritesNumber == null) {
            favoritesNumber = 0;
        }
        return Result.ok(favoritesNumber);
    }

    /**
     * @param recipeId
     * @return 根据菜谱id查询喜欢数量
     */
    @Override
    public Result likesByRecipeId(int recipeId) {
        Integer likesNumber = recipeMapper.likesByRecipeId(recipeId);
        if (likesNumber == null) {
            likesNumber = 0;
        }
        return Result.ok(likesNumber);
    }

    /**
     * @return 热门收藏菜谱
     */
    @Override
    public Result popularFavorites() {
        ArrayList<ShowRecipeVo> ShowRecipeVoList = new ArrayList<>();
        ShowRecipeVoList = recipeMapper.popularFavorites();
        return Result.ok(ShowRecipeVoList);

    }

    /**
     * @return * 热门点赞菜谱
     */
    @Override
    public Result popularLikes() {
        ArrayList<ShowRecipeVo> ShowRecipeVoList = new ArrayList<>();
        ShowRecipeVoList = recipeMapper.popularLikes();
        return Result.ok(ShowRecipeVoList);
    }

    // 热门点赞前十
}